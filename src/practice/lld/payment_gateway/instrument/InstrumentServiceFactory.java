package practice.lld.payment_gateway.instrument;

public class InstrumentServiceFactory {

    public InstrumentService getInstrumentServiceFactory(InstrumentType instrumentType){
        if(instrumentType==InstrumentType.BANK){
            return new BankService();
        }

        if(instrumentType==InstrumentType.CARD){
            return new CardService();
        }

        return null;
    }
}
