package practice.lld.payment_service;

public class CreditCardPaymentProcessor implements PaymentProcessor{
    @Override
    public Boolean processPayment(PaymentRequest paymentRequest) {
        var cardNumber=paymentRequest.getCardNumber();
        var cvv=paymentRequest.getCvv();
        var expiryDate=paymentRequest.getExpiryDate();
        // process payment to gateway

        return true;
    }

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.CREDIT_CARD;
    }
}
