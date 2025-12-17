package practice.lld.payment_gateway.Main;

import practice.lld.payment_gateway.instrument.*;
import practice.lld.payment_gateway.process.PaymentProcesser;
import practice.lld.payment_gateway.transaction.Transaction;
import practice.lld.payment_gateway.transaction.TransactionDao;
import practice.lld.payment_gateway.transaction.TransactionService;
import practice.lld.payment_gateway.user.UserDao;
import practice.lld.payment_gateway.user.UserService;

import java.time.LocalDate;
import java.util.List;

public class Main {

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

        InstrumentServiceFactory instrumentServiceFactory=new InstrumentServiceFactory();
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
        for(var instrument: InstrumentService.getInstrumentsByUserId(user1.getUserId())){
            System.out.println("Instrument type: "+instrument.getInstrumentType().name());
            System.out.println("Instrument id: "+instrument.getInstrumentId());
        }

        System.out.println("Instruments of user 2");
        for(var instrument: InstrumentService.getInstrumentsByUserId(user2.getUserId())){
            System.out.println("Instrument type: "+instrument.getInstrumentType().name());
            System.out.println("Instrument id: "+instrument.getInstrumentId());
        }

        TransactionService transactionService=new TransactionService(new PaymentProcesser());
        TransactionDao transactionDao=new TransactionDao();
        transactionDao.setAmount(344.00);
        transactionDao.setSenderId(user1.getUserId());
        transactionDao.setReceiverId(user2.getUserId());
        transactionDao.setSenderInstrumentId(InstrumentService.getInstrumentsByUserId(user1.getUserId()).getFirst().getInstrumentId());
        transactionDao.setReceiverInstrumentId(InstrumentService.getInstrumentsByUserId(user2.getUserId()).getFirst().getInstrumentId());
        transactionDao.setReceiverId(user2.getUserId());
        transactionService.initiateTransaction(transactionDao);
        System.out.println("Transaction is completed");

        var transactionHistory1= transactionService.getTransactionHistory(user1.getUserId());

        System.out.println("Transaction history for user 1:");
        transactionHistory1.forEach(transaction -> {
            System.out.println("Transaction:-");
            System.out.println(transaction.getTransactionId());
            System.out.println(transaction.getAmount());
            System.out.println(transaction.getCreatedAt());
            System.out.println(transaction.getReceiverId());
            System.out.println(transaction.getSenderId());
            System.out.println(transaction.getLastUpdatedAt());
            System.out.println(transaction.getTransactionStatus().name());
            System.out.println();
        });

        var transactionHistory2= transactionService.getTransactionHistory(user2.getUserId());

        System.out.println("Transaction history for user 2:");
        transactionHistory2.forEach(transaction -> {
            System.out.println("Transaction:-");
            System.out.println(transaction.getTransactionId());
            System.out.println(transaction.getAmount());
            System.out.println(transaction.getCreatedAt());
            System.out.println(transaction.getReceiverId());
            System.out.println(transaction.getSenderId());
            System.out.println(transaction.getLastUpdatedAt());
            System.out.println(transaction.getTransactionStatus().name());
            System.out.println();
        });
    }


}
