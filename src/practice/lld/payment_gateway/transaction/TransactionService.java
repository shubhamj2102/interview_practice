package practice.lld.payment_gateway.transaction;

import practice.lld.payment_gateway.instrument.InstrumentRepository;
import practice.lld.payment_gateway.instrument.InstrumentService;
import practice.lld.payment_gateway.process.PaymentProcesser;

import java.util.*;

public class TransactionService {

    private static final Map<String, List<TransactionEntry>> transactionHistory=new HashMap<>();;
    private final PaymentProcesser paymentProcesser;
    private final InstrumentRepository instrumentRepository;
    private final TransactionRepository transactionRepository;


    public TransactionService(PaymentProcesser paymentProcesser,InstrumentRepository instrumentRepository,TransactionRepository transactionRepository) {
        this.paymentProcesser = paymentProcesser;
        this.instrumentRepository=instrumentRepository;
        this.transactionRepository =transactionRepository;

    }

    public void initiateTransaction(TransactionDao transactionDao) {
        var senderInstrumentId = transactionDao.getSenderInstrumentId();
        var receiverInstrumentId = transactionDao.getReceiverInstrumentId();

        var senderInstrument = instrumentRepository.findByUserAndInstrumentId(transactionDao.getSenderId(),senderInstrumentId);
        var receiverInstrument = instrumentRepository.findByUserAndInstrumentId(transactionDao.getReceiverId(),receiverInstrumentId);

        var txn=new Transaction();
        var txnId= UUID.randomUUID();
        txn.setTransactionId(txnId);
        txn.setAmount(transactionDao.getAmount());
        txn.setSenderId(transactionDao.getSenderId());
        txn.setReceiverId(transactionDao.getReceiverId());
        txn.setSenderInstrumentId(senderInstrumentId);
        txn.setReceiverInstrumentId(receiverInstrumentId);

        try{
            paymentProcesser.ProcessPayment(senderInstrument,receiverInstrument,transactionDao.getAmount());
            txn.setTransactionStatus(TransactionStatus.SUCCESS);
        }catch (Exception e){
            txn.setTransactionStatus(TransactionStatus.FAIL);
        }

        transactionRepository.save(txn);

        TransactionEntry senderTxnEntry=new TransactionEntry();

        senderTxnEntry.setEntryType(EntryType.DEBIT);
        senderTxnEntry.setTransactionStatus(txn.getTransactionStatus());
        senderTxnEntry.setAmount(txn.getAmount());
        senderTxnEntry.setSenderId(txn.getSenderId());
        senderTxnEntry.setTransactionId(txn.getTransactionId());
        senderTxnEntry.setReceiverId(txn.getReceiverId());

        TransactionEntry recieverTxnEntry=new TransactionEntry();

        recieverTxnEntry.setEntryType(EntryType.CREDIT);
        recieverTxnEntry.setTransactionStatus(txn.getTransactionStatus());
        recieverTxnEntry.setAmount(txn.getAmount());
        recieverTxnEntry.setSenderId(txn.getSenderId());
        recieverTxnEntry.setTransactionId(txn.getTransactionId());
        recieverTxnEntry.setReceiverId(txn.getReceiverId());
        transactionHistory.putIfAbsent(transactionDao.getSenderId(),new ArrayList<>());
        transactionHistory.get(transactionDao.getSenderId()).add(senderTxnEntry);
        transactionHistory.putIfAbsent(transactionDao.getReceiverId(),new ArrayList<>());
        transactionHistory.get(transactionDao.getReceiverId()).add(recieverTxnEntry);
    }

    public List<TransactionEntry> getTransactionHistory(String userId){
        return transactionHistory.get(userId);
    }
}
