package practice.multithreading.odd_even;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class OddEvenPrintByLock {

    private int limit;

    private int currNum;

    private Lock lock;

    private Condition condition;

    public OddEvenPrintByLock(int limit, Lock lock) {
        this.limit = limit;
        this.currNum=1;
        this.lock=lock;
        condition=lock.newCondition();
    }

    public void printEven()  {
        lock.lock();
        try{
            while(currNum<=limit) {

                if (currNum % 2 == 0) {
                    System.out.println(currNum);
                    currNum += 1;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

    }

    public void printOdd()  {
        lock.lock();
        try{
        while(currNum<=limit) {

            if (currNum % 2 == 1) {
                System.out.println(currNum);
                currNum += 1;
                condition.signalAll();
            } else {
                condition.await();
            }
        }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }

    }


}
