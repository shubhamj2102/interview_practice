package practice.multithreading.odd_even;

import java.util.concurrent.locks.ReentrantLock;

public class main {
    public static void main(String[] args) throws InterruptedException {

        PrintNumbers pn=new PrintNumbers(100);

        var evenTh=new Thread(pn::printEven);
        var oddTh=new Thread(pn::printOdd);
        evenTh.start();
        oddTh.start();

        OddEvenPrintByLock oddEvenPrintByLock =new OddEvenPrintByLock(100,new ReentrantLock());

        Thread evenThread=new Thread(()-> oddEvenPrintByLock.printEven());
        Thread oddThread=new Thread(()-> oddEvenPrintByLock.printOdd());
        evenTh.join();
        oddTh.join();
        evenThread.start();
        oddThread.start();
    }
}
