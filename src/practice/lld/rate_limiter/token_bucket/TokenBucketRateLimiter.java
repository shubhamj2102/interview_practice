package practice.lld.rate_limiter.token_bucket;

public class TokenBucketRateLimiter {


    private int token;
    private final int capacity;
    private final int fillingRate;
    private long lastFilledTime; // token/secone

    public TokenBucketRateLimiter(int capacity, int fillingRate) {
        this.capacity = capacity;
        this.token=capacity;
        this.fillingRate=fillingRate;
        this.lastFilledTime =System.currentTimeMillis();
    }

    public synchronized Boolean getTheRequest(){
        fillBucket();
       if(token>0){
           System.out.println("request is accepted");
           token--;
           return true;
       }

        System.out.println("request is denied");
       return false;
   }

   public void fillBucket(){
        long currTime=System.currentTimeMillis();
        int timeElapsed=(int)(currTime-lastFilledTime)/1000;
        int tokenToAdd=timeElapsed*fillingRate;
        if(tokenToAdd>0){
            token=Math.min(capacity, token+tokenToAdd);
            lastFilledTime +=timeElapsed*1000;
        }
   }
}
