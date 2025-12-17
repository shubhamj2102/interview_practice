package practice.lld.payment_gateway.instrument;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public abstract class InstrumentService {

    public static Map<String, List<Instrument>> instrumentList= new HashMap<>();

    public abstract void addInstrument(InstrumentDao instrumentDao);
    public static List<Instrument> getInstrumentsByUserId(String userId){
        return instrumentList.getOrDefault(userId,List.of());
    }

    public static Instrument getInstrumentByInstrumentId(String userId, int instrumentId){
        if(instrumentList.containsKey(userId)){
           return instrumentList.get(userId).stream().filter(instrument ->instrumentId== instrument.getInstrumentId()).findFirst().orElseThrow(()->new NoSuchElementException("No instrument found with instrument id="+instrumentId));
        }

        throw new NoSuchElementException("No user found with this userId="+userId);
    }

}
