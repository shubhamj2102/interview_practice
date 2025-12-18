package practice.lld.payment_gateway.instrument;

import java.util.*;

public class InstrumentRepository {
    public  Map<String, List<Instrument>> instrumentList= new HashMap<>();

    public void save(String userId, Instrument instrument){
        instrumentList.putIfAbsent(userId, new ArrayList<>());
        instrumentList.get(userId).add(instrument);
    }

    public List<Instrument> findAllByUserId(String userId){
       return instrumentList.getOrDefault(userId,List.of());
    }

    public Instrument findByUserAndInstrumentId(String userId, int instrumentId) {
        return instrumentList.getOrDefault(userId, List.of())
                .stream()
                .filter(i -> i.getInstrumentId() == instrumentId)
                .findFirst()
                .orElseThrow(() ->
                        new NoSuchElementException("Instrument not found"));
    }
}
