package practice.multithreading.excutorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(2,5,1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10));


        // with no return value from task, runnable task
       Future<?> future1= threadPoolExecutor.submit(()->{
            System.out.println("with no return value from task, runnable task");
        });


       // with output from task, runnable task

        List<Integer> list=new ArrayList<>();
        Future<List<Integer>> future2=threadPoolExecutor.submit(()->{
            list.add(500);
            System.out.println("with output from task, runnable task");
        },list);


        // With callable task . return value from task

        Future<List<Integer>> future3=threadPoolExecutor.submit(()->{
            List<Integer> list1=new ArrayList<>();
            System.out.println("With callable task . return value from task");
            return list1;
        });

    }
}
