package practice.lld.payment_gateway.instrument;

public class CardService implements InstrumentService{
    private final InstrumentRepository instrumentRepository;

    public CardService(InstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }

    @Override
    public void addInstrument(InstrumentDao instrumentDao) {
        var userId= instrumentDao.getUserId();
        var instrumentId=generateInstrumentId(userId);
        var cardNumber=instrumentDao.getCardNumber();
        var cvv=instrumentDao.getCvv();
        var expiryDate=instrumentDao.getExpiryDate();
        var instrument=new CardInstrument(instrumentId,userId,cardNumber,cvv,expiryDate);
        instrumentRepository.save(userId,instrument);
        System.out.println("card instrument is added with instrument id:"+instrumentId);
    }

    private int generateInstrumentId(String userId){
        if(instrumentRepository.findAllByUserId(userId).isEmpty()){
            return 1;
        }
        return instrumentRepository.findAllByUserId(userId).getLast().getInstrumentId()+1;
    }
}
