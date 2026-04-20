package practice.lld.task_execution_framework;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelExecutionStrategy implements TaskExecutionStrategy{

    @Override
    public List<Object> executeTask(List<Task<?>> taskList) throws InterruptedException {

        int n=taskList.size();

        ExecutorService executorService= Executors.newFixedThreadPool(10);
        List<Future<Object>> futures=new ArrayList<>();
        LocalTime startTime=LocalTime.now();
        for(Task<?> task:taskList){
        Future<Object> future= executorService.submit(task::execute);
           futures.add(future);
        }

        List<Object> result=new ArrayList<>();
        for(Future<Object> future:futures){

            try {
                result.add(future.get());
            } catch (Exception e) {
                result.add(null);
            }
        }

        LocalTime endTime=LocalTime.now();
        System.out.println(" time taken in parallel: "+ Duration.between(startTime,endTime).toMillis());
        executorService.shutdown();
        return  result;
    }
}
