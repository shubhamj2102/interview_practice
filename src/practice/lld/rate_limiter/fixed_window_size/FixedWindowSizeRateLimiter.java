package practice.lld.rate_limiter.fixed_window_size;

public class FixedWindowSizeRateLimiter {

    private long startTime;
    private final long windowSize;
    private int counter;
    private final int windowCapacity;


    public FixedWindowSizeRateLimiter(long windowSize, int windowCapacity) {
        this.startTime =System.currentTimeMillis();
        this.windowSize = windowSize;
        this.windowCapacity=windowCapacity;
        this.counter=0;
    }

    public synchronized boolean allowRequest(){

        long currTime=System.currentTimeMillis();
       if(currTime>=startTime+windowSize){
           startTime=startTime+((currTime-startTime)/windowSize)*windowSize;
           counter=0;
       }
       if(counter>=windowCapacity){
           System.out.println("request is denied");
           return false;
       }
        System.out.println("request is accepted");

       counter++;

       return true;
    }
}
