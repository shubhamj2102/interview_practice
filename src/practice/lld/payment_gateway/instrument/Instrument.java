package practice.lld.payment_gateway.instrument;

public abstract class Instrument {
    private int instrumentId;
    private InstrumentType instrumentType;
    private String userId;

    public Instrument(int instrumentId, InstrumentType instrumentType, String userId) {
        this.instrumentId = instrumentId;
        this.instrumentType = instrumentType;
        this.userId = userId;
    }

    public int getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(int instrumentId) {
        this.instrumentId = instrumentId;
    }

    public InstrumentType getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(InstrumentType instrumentType) {
        this.instrumentType = instrumentType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
