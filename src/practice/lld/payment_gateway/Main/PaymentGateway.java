package practice.lld.payment_gateway.Main;

import practice.lld.payment_gateway.instrument.*;
import practice.lld.payment_gateway.process.InstrumentProcessorResolver;
import practice.lld.payment_gateway.process.PaymentProcesser;
import practice.lld.payment_gateway.transaction.TransactionDao;
import practice.lld.payment_gateway.transaction.TransactionRepository;
import practice.lld.payment_gateway.transaction.TransactionService;
import practice.lld.payment_gateway.user.UserDao;
import practice.lld.payment_gateway.user.UserService;

import java.time.LocalDate;

public class PaymentGateway {

    public static void main(String[] args) {

        UserDao user1=new UserDao("123","user12","12222222");
        UserDao user2=new UserDao("456","user2","4234242343");

        UserService userService=new UserService();
        userService.addUser(user1);
        userService.addUser(user2);

        InstrumentDao instrumentDao1=new InstrumentDao();
        instrumentDao1.setInstrumentType(InstrumentType.BANK);
        instrumentDao1.setBankAcNumber("1222333");
        instrumentDao1.setBankName("HDFC");
        instrumentDao1.setIfscCode("HDFC0000");
        instrumentDao1.setUserId(user1.getUserId());

        InstrumentRepository instrumentRepository=new InstrumentRepository();

        InstrumentServiceFactory instrumentServiceFactory=new InstrumentServiceFactory(instrumentRepository);
        InstrumentService instrumentService=instrumentServiceFactory.getInstrumentServiceFactory(instrumentDao1.getInstrumentType());
        instrumentService.addInstrument(instrumentDao1);


        InstrumentDao instrumentDao2=new InstrumentDao();
        instrumentDao2.setInstrumentType(InstrumentType.CARD);
        instrumentDao2.setCardNumber("177776889900");
        instrumentDao2.setCvv("444");
        instrumentDao2.setExpiryDate(LocalDate.of(2030,4,11));
        instrumentDao2.setUserId(user2.getUserId());

        InstrumentService instrumentService2=instrumentServiceFactory.getInstrumentServiceFactory(instrumentDao2.getInstrumentType());
        instrumentService2.addInstrument(instrumentDao2);

        System.out.println("Instuments of user 1");
        for(var instrument: instrumentRepository.findAllByUserId(user1.getUserId())){
            System.out.println("Instrument type: "+instrument.getInstrumentType().name());
            System.out.println("Instrument id: "+instrument.getInstrumentId());
        }

        System.out.println("Instruments of user 2");
        for(var instrument: instrumentRepository.findAllByUserId(user2.getUserId())){
            System.out.println("Instrument type: "+instrument.getInstrumentType().name());
            System.out.println("Instrument id: "+instrument.getInstrumentId());
        }

        var instrumentProcessorResolver=new InstrumentProcessorResolver ();
        var paymentProcesser=new PaymentProcesser(instrumentProcessorResolver);
        var transactionRepository=new TransactionRepository();

        TransactionService transactionService=new TransactionService(paymentProcesser,instrumentRepository,transactionRepository);
        TransactionDao transactionDao=new TransactionDao();
        transactionDao.setAmount(344.00);
        transactionDao.setSenderId(user1.getUserId());
        transactionDao.setReceiverId(user2.getUserId());
        transactionDao.setSenderInstrumentId(instrumentRepository.findAllByUserId(user1.getUserId()).getFirst().getInstrumentId());
        transactionDao.setReceiverInstrumentId(instrumentRepository.findAllByUserId(user2.getUserId()).getFirst().getInstrumentId());
        transactionDao.setReceiverId(user2.getUserId());
        transactionService.initiateTransaction(transactionDao);
        System.out.println("Transaction is completed");

        var transactionHistory1= transactionService.getTransactionHistory(user1.getUserId());

        System.out.println("Transaction history for user 1:");
        transactionHistory1.forEach(transactionEntry -> {
            System.out.println(transactionEntry.getAmount()+ " "+ transactionEntry.getEntryType().name()+"ed"+" at "+transactionEntry.getTimestamp());
        });

        var transactionHistory2= transactionService.getTransactionHistory(user2.getUserId());

        System.out.println("Transaction history for user 2:");
        transactionHistory2.forEach(transactionEntry -> {
            System.out.println(transactionEntry.getAmount()+ " "+ transactionEntry.getEntryType().name()+"ed"+" at "+transactionEntry.getTimestamp());
        });
    }


}
