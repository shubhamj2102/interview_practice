package practice.lld.payment_gateway.transaction;

import practice.lld.payment_gateway.instrument.InstrumentType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private UUID transactionId;
    private double amount;
    private int senderInstrumentId;
    private TransactionStatus transactionStatus;
    private final LocalDateTime createdAt;
    private LocalDateTime lastUpdatedAt;
    private String senderId;
    private String receiverId;
    private int receiverInstrumentId;

    public Transaction() {
        this.createdAt=LocalDateTime.now();
        this.transactionStatus=TransactionStatus.PENDING;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getSenderInstrumentId() {
        return senderInstrumentId;
    }

    public void setSenderInstrumentId(int senderInstrumentId) {
        this.senderInstrumentId = senderInstrumentId;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
        this.lastUpdatedAt=LocalDateTime.now();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public LocalDateTime getLastUpdatedAt() {
        return lastUpdatedAt;
    }


    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public int getReceiverInstrumentId() {
        return receiverInstrumentId;
    }

    public void setReceiverInstrumentId(int receiverInstrumentId) {
        this.receiverInstrumentId = receiverInstrumentId;
    }
}
