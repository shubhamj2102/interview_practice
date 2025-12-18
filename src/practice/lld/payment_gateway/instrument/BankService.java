package practice.lld.payment_gateway.instrument;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BankService implements InstrumentService{
    private final InstrumentRepository instrumentRepository;

    public BankService(InstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }

    @Override
    public void addInstrument(InstrumentDao instrumentDao) {
       var userId= instrumentDao.getUserId();
        var instrumentId=generateInstrumentId(userId);
        var bankAcNumber=instrumentDao.getBankAcNumber();
        var ifscCode=instrumentDao.getIfscCode();
        var instrument=new BankInstrument(instrumentId,userId,bankAcNumber,ifscCode);
        instrumentRepository.save(userId,instrument);
        System.out.println("Bank is added with instrument id: "+instrumentId);
    }

    private int generateInstrumentId(String userId){
        if(instrumentRepository.findAllByUserId(userId).isEmpty()){
            return 1;
        }
        return instrumentRepository.findAllByUserId(userId).getLast().getInstrumentId()+1;
    }
}
