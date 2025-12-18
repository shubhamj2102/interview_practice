package practice.lld.payment_gateway.process;

import practice.lld.payment_gateway.instrument.Instrument;

public interface InstrumentProcessor {

     void validateInstrument(Instrument instrument);
     void hasSufficientBalance(Instrument instrument);
     void debit(Instrument instrument);
     void credit(Instrument instrument);
}
