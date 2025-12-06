package practice.lld.payment_service;

public class UPIPaymentProcessor implements PaymentProcessor{
    @Override
    public Boolean processPayment(PaymentRequest paymentRequest) {
        var upiId=paymentRequest.getUpiId();
        // initiate payment;
        return true;
    }

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.UPI;
    }
}
