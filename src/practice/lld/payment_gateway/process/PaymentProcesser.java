package practice.lld.payment_gateway.process;

import practice.lld.payment_gateway.instrument.Instrument;

public class PaymentProcesser {

   private final InstrumentProcessorResolver instrumentProcessorResolver;

   public PaymentProcesser(InstrumentProcessorResolver instrumentProcessorResolver) {
      this.instrumentProcessorResolver = instrumentProcessorResolver;
   }

   public void ProcessPayment(Instrument senderInstrument, Instrument receiverInstrument, double amount){

      // validate the instruments

     var senderInstrumentProcessor= instrumentProcessorResolver.resolve(senderInstrument.getInstrumentType());
     var recieverInstrumentProcessor=instrumentProcessorResolver.resolve(receiverInstrument.getInstrumentType());
      senderInstrumentProcessor.validateInstrument(senderInstrument);
      recieverInstrumentProcessor.validateInstrument(receiverInstrument);
      // check senders balance for transaction
      senderInstrumentProcessor.hasSufficientBalance(senderInstrument);

      // debit the money

      senderInstrumentProcessor.debit(senderInstrument);

      // credit to money to receiver.

      recieverInstrumentProcessor.credit(receiverInstrument);
   }
}
