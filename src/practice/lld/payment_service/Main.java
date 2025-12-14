package practice.lld.payment_service;

import java.lang.ref.WeakReference;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PaymentService paymentService=new PaymentService();

        PaymentRequest paymentRequest=new PaymentRequest();
        paymentRequest.setAmount(100.00);
        paymentRequest.setPaymentType("Credit Card");
        paymentRequest.setCardNumber("12345467890");
        paymentRequest.setCvv("345");
        paymentRequest.setExpiryDate(LocalDate.of(2030,4,21));

        paymentService.initiatePayment(paymentRequest);
        
    }
}
