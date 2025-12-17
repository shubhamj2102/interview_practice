package practice.lld.payment_gateway.transaction;

public class TransactionDao {

    private double amount;
    private String senderId;
    private String receiverId;
    private int senderInstrumentId;
    private int receiverInstrumentId;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

    public int getSenderInstrumentId() {
        return senderInstrumentId;
    }

    public void setSenderInstrumentId(int senderInstrumentId) {
        this.senderInstrumentId = senderInstrumentId;
    }

    public int getReceiverInstrumentId() {
        return receiverInstrumentId;
    }

    public void setReceiverInstrumentId(int receiverInstrumentId) {
        this.receiverInstrumentId = receiverInstrumentId;
    }
}
