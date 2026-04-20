package practice.multithreading.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {

    Queue<Integer> queue=new LinkedList<>();
    int size=50;

    public synchronized void produce(int item){

            while(queue.size()==size){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            queue.add(item);
        System.out.println("Produced: " + item);
            notifyAll();

    }

    public synchronized void consume(){

        while(queue.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

       int item= queue.poll();
        System.out.println("Consumed: " + item);
        notifyAll();
    }
}
