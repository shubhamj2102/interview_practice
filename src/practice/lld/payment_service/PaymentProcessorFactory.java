package practice.lld.payment_service;

public class PaymentProcessorFactory {

    public static PaymentProcessor getPaymentProcessor(String paymentType){
        if(PaymentType.DEBIT_CARD.getValue().equals(paymentType)){
            return new DebitCardPaymentProcesser();
        }

        if(PaymentType.CREDIT_CARD.getValue().equalsIgnoreCase(paymentType)){
            return new CreditCardPaymentProcessor();
        }

        if(PaymentType.UPI.getValue().equalsIgnoreCase(paymentType)){
            return new UPIPaymentProcessor();
        }

        if(PaymentType.WALLET.getValue().equalsIgnoreCase(paymentType)){
            return new WalletPaymentProcessor();
        }

        return null;
    }
}
