package practice.lld.payment_gateway.instrument;

import practice.lld.payment_gateway.user.UserDao;

import java.time.LocalDate;

public class CardInstrument extends Instrument{
    private String cardNumber;
    private String cvv;
    private LocalDate expiryDate;

    public CardInstrument(int instrumentId, String userId,String cardNumber, String cvv,LocalDate expiryDate){
        super(instrumentId,InstrumentType.CARD, userId);
        this.cardNumber=cardNumber;
        this.cvv=cvv;
        this.expiryDate=expiryDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}
