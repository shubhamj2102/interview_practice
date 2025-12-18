package practice.lld.payment_gateway.process;

import practice.lld.payment_gateway.instrument.Instrument;

public class CardProcessor implements InstrumentProcessor{

    @Override
    public void validateInstrument(Instrument instrument) {

    }

    @Override
    public void hasSufficientBalance(Instrument instrument) {

    }

    @Override
    public void debit(Instrument instrument) {

    }

    @Override
    public void credit(Instrument instrument) {

    }
}
