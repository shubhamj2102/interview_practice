package practice.lld.rate_limiter.leaky_bucket;

public class LeakyBucketRateLimiter {

    private final int capacity;
    private int currLevel;
    private long lastLeakTime;
    private final int leakPerSecond;

    public LeakyBucketRateLimiter(int queueSize, int leakPerSecond) {
        this.capacity = queueSize;
        this.leakPerSecond = leakPerSecond;
        this.currLevel=0;
        this.lastLeakTime=System.currentTimeMillis();
    }

    public synchronized boolean allowRequest(){
        leak();
        if(currLevel<capacity){
            currLevel++;
            System.out.println("Request accepted");
            return true;
        }
        System.out.println("request denied");
        return false;
    }

    private void leak(){
        long currTime=System.currentTimeMillis();
        int elapsedSeconds=(int)(currTime-lastLeakTime)/1000;
        int leakedLevel=elapsedSeconds*leakPerSecond;
        currLevel=Math.max(0,currLevel-leakedLevel);
        lastLeakTime+=elapsedSeconds*1000;
    }
}
