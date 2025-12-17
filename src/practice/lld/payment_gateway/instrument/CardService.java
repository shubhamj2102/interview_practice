package practice.lld.payment_gateway.instrument;

import java.util.ArrayList;

public class CardService extends InstrumentService{

    @Override
    public void addInstrument(InstrumentDao instrumentDao) {
        var userId= instrumentDao.getUserId();
        var instrumentId=generateInstrumentId(userId);
        var cardNumber=instrumentDao.getCardNumber();
        var cvv=instrumentDao.getCvv();
        var expiryDate=instrumentDao.getExpiryDate();
        var instrument=new CardInstrument(instrumentId,userId,cardNumber,cvv,expiryDate);
        instrumentList.putIfAbsent(userId, new ArrayList<>());
        instrumentList.get(userId).add(instrument);
        System.out.println("card instrument is added with instrument id:"+instrumentId);
    }

    private int generateInstrumentId(String userId){
        if(!instrumentList.containsKey(userId)){
            return 1;
        }
        return instrumentList.get(userId).getLast().getInstrumentId()+1;
    }
}
