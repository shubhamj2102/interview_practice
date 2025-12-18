package practice.lld.payment_gateway.instrument;

public class InstrumentServiceFactory {

    private InstrumentRepository instrumentRepository;

    public InstrumentServiceFactory(InstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }

    public InstrumentService getInstrumentServiceFactory(InstrumentType instrumentType){
        if(instrumentType==InstrumentType.BANK){
            return new BankService(instrumentRepository);
        }

        if(instrumentType==InstrumentType.CARD){
            return new CardService(instrumentRepository);
        }

        return null;
    }
}
