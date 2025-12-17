package practice.lld.payment_gateway.instrument;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BankService extends InstrumentService{

    @Override
    public void addInstrument(InstrumentDao instrumentDao) {
       var userId= instrumentDao.getUserId();
        var instrumentId=generateInstrumentId(userId);
        var bankAcNumber=instrumentDao.getBankAcNumber();
        var ifscCode=instrumentDao.getIfscCode();
        var instrument=new BankInstrument(instrumentId,userId,bankAcNumber,ifscCode);
        instrumentList.putIfAbsent(userId, new ArrayList<>());
        instrumentList.get(userId).add(instrument);
        System.out.println("Bank is added with instrument id: "+instrumentId);
    }

    private int generateInstrumentId(String userId){
        if(!instrumentList.containsKey(userId)){
            return 1;
        }
       return instrumentList.get(userId).getLast().getInstrumentId()+1;
    }
}
