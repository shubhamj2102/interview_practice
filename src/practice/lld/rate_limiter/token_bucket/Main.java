package practice.lld.rate_limiter.token_bucket;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TokenBucketRateLimiter tokenBucketRateLimiter=new TokenBucketRateLimiter(10,2);

        for(int i=0;i<20;i++){
            tokenBucketRateLimiter.getTheRequest();
            if(i==10){
                Thread.sleep(1000);
            }
        }
    }
}
