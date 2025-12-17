package practice.lld.payment_gateway.instrument;

public class BankInstrument extends Instrument{

    private String bankAcNumber;
    private String ifscCode;

    public BankInstrument(int instrumentId, String userId,String bankAcNumber, String ifscCode){
        super(instrumentId,InstrumentType.BANK,userId);
        this.bankAcNumber=bankAcNumber;
        this.ifscCode=ifscCode;
    }

    public String getBankAcNumber() {
        return bankAcNumber;
    }

    public void setBankAcNumber(String bankAcNumber) {
        this.bankAcNumber = bankAcNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }
}
