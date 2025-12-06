package practice.lld.payment_service;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaymentService {

    private static final Logger logger = Logger.getLogger(PaymentService.class.getName());
    public void initiatePayment(PaymentRequest paymentRequest){
        logger.log(Level.INFO,"Initiated payment");
        var paymentProcessor=PaymentProcessorFactory.getPaymentProcessor(paymentRequest.getPaymentType());

        if(Objects.isNull(paymentProcessor)){
            throw new IllegalArgumentException();
        }
        logger.log(Level.INFO,"Fetched Payment processor type of "+paymentProcessor.getPaymentType());
        var transaction=new Transaction(paymentProcessor.getPaymentType(),paymentRequest.getAmount(),paymentRequest.getUserId());
        // save this transaction in DB

        logger.log(Level.INFO,"Transaction saved in DB in Pending state. TId is :"+transaction.getTransactionalId());

      var staus=  paymentProcessor.processPayment(paymentRequest);
        logger.log(Level.INFO,"Payment is processed with success="+staus);
      transaction.updatePaymentStatus(staus?PaymentStatus.SUCCESS:PaymentStatus.FAIL);

      //save transaction again in DB
    }
}
