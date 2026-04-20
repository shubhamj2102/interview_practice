package practice.lld.task_execution_framework;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SequenceExecutionStrategy implements TaskExecutionStrategy{
    @Override
    public List<Object> executeTask(List<Task<?>> taskList) throws InterruptedException {

        LocalTime startTime=LocalTime.now();
        List<Object> result=new ArrayList<>();
        for(Task<?> task:taskList){
           result.add(task.execute());
        }
        LocalTime endTime=LocalTime.now();

        System.out.println(" time taken in sequence: "+ Duration.between(startTime,endTime).toMillis());
        return result;
    }
}
