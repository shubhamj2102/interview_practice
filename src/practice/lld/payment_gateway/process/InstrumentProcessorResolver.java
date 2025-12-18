package practice.lld.payment_gateway.process;

import practice.lld.payment_gateway.instrument.InstrumentType;

public class InstrumentProcessorResolver {

    public InstrumentProcessor resolve(InstrumentType instrumentType){
        if(instrumentType==InstrumentType.BANK){
            return new BankProcessor();
        }

        if(instrumentType==InstrumentType.CARD){
            return new CardProcessor();
        }

        if(instrumentType==InstrumentType.WALLET){
            return new WalletProcessor();
        }

        return null;
    }
}
