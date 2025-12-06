package practice.lld.payment_service;

public interface PaymentProcessor {

    Boolean processPayment(PaymentRequest paymentRequest);
    PaymentType getPaymentType();
}
