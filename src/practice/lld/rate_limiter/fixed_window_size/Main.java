package practice.lld.rate_limiter.fixed_window_size;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        FixedWindowSizeRateLimiter fixedWindowSizeRateLimiter=new FixedWindowSizeRateLimiter(1000,5);
        for(int i=1;i<=20;i++){
           var result= fixedWindowSizeRateLimiter.allowRequest();
            if(i==10){
                Thread.sleep(1000);
            }
        }
    }
}
