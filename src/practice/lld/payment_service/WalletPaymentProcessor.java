package practice.lld.payment_service;

public class WalletPaymentProcessor implements PaymentProcessor{
    @Override
    public Boolean processPayment(PaymentRequest paymentRequest) {
        var walletId=paymentRequest.getWalletId();

        return true;
    }

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.WALLET;
    }
}
