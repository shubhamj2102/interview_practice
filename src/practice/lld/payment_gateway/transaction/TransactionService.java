package practice.lld.payment_gateway.transaction;

import practice.lld.payment_gateway.instrument.InstrumentService;
import practice.lld.payment_gateway.process.PaymentProcesser;

import java.util.*;

public class TransactionService {

    private static final Map<String, List<Transaction>> transactionHistory=new HashMap<>();;
    private final PaymentProcesser paymentProcesser;


    public TransactionService(PaymentProcesser paymentProcesser) {
        this.paymentProcesser = paymentProcesser;
    }

    public void initiateTransaction(TransactionDao transactionDao) {
        var senderInstrumentId = transactionDao.getSenderInstrumentId();
        var receiverInstrumentId = transactionDao.getReceiverInstrumentId();

        var senderInstrument = InstrumentService.getInstrumentByInstrumentId(transactionDao.getSenderId(),senderInstrumentId);
        var receiverInstrument = InstrumentService.getInstrumentByInstrumentId(transactionDao.getReceiverId(),receiverInstrumentId);

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

        transactionHistory.putIfAbsent(transactionDao.getSenderId(),new ArrayList<>());
        transactionHistory.get(transactionDao.getSenderId()).add(txn);
        transactionHistory.putIfAbsent(transactionDao.getReceiverId(),new ArrayList<>());
        transactionHistory.get(transactionDao.getReceiverId()).add(txn);
    }

    public List<Transaction> getTransactionHistory(String userId){
        return transactionHistory.get(userId);
    }
}
