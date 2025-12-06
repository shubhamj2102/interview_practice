package practice.lld.payment_service;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private final UUID transactionalId;
    private final PaymentType paymentMode;
    private final Double amount;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private PaymentStatus paymentStatus;
    private final String userId;

    public Transaction(PaymentType paymentMode, Double amount, String userId) {
        this.paymentMode = paymentMode;
        this.amount = amount;
        this.userId = userId;
        this.transactionalId=UUID.randomUUID();
        this.createdAt=LocalDateTime.now();
        this.updatedAt=LocalDateTime.now();
        this.paymentStatus=PaymentStatus.PENDING;
    }

    public void updatePaymentStatus(PaymentStatus paymentStatus){
        this.paymentStatus=paymentStatus;
        this.updatedAt=LocalDateTime.now();
    }

    public UUID getTransactionalId() {
        return transactionalId;
    }

    public PaymentType getPaymentMode() {
        return paymentMode;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public String getUserId() {
        return userId;
    }
}
