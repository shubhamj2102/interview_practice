package practice.lld.rate_limiter.leaky_bucket;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        LeakyBucketRateLimiter leakyBucketRateLimiter=new LeakyBucketRateLimiter(5,5);

        for(int i=1;i<=20;i++){
            leakyBucketRateLimiter.allowRequest();

            if(i==10){
                Thread.sleep(1000);
            }
        }
    }
}
