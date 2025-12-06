package practice.lld.payment_service;

public enum PaymentType {
    CREDIT_CARD ("Credit Card"),
    DEBIT_CARD ("Debit Card"),
    UPI ("UPI"),
    WALLET ("Wallet");

    PaymentType(String s) {
        this.value=s;
    }

    private final String value;

    public String getValue() {
        return value;
    }
}
