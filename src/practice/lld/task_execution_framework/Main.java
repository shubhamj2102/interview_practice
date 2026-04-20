package practice.lld.task_execution_framework;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Task<String> task1=()-> "this is task 1";

        Task<String> task2=()-> "this is task 2";

        Task<String> task3=()-> "this is task 3";

        Task<String> task4=()->"this is task 4" ;

        Task<String> task5=()-> "this is task 5";

        Task<String> task6=()-> "this is task 6";

        Task<String> task7=()-> "this is task 7";

        Task<String> task8=()-> "this is task 8";


        List<Task<?>> list=new ArrayList<>();

        list.add(task1);
        list.add(task2);
        list.add(task3);
        list.add(task4);
        list.add(task5);
        list.add(task6);
        list.add(task7);
        list.add(task8);
        list.add(task1);
        list.add(task2);
        list.add(task3);
        list.add(task4);
        list.add(task5);
        list.add(task6);
        list.add(task7);
        list.add(task8);

        TaskExecutionRequest taskExecutionRequest=new TaskExecutionRequest();

        taskExecutionRequest.setTaskList(list);
        taskExecutionRequest.setExecutionType(ExecutionType.PARALLEL);

        TaskExecutorService taskExecutorService=new TaskExecutorService();

      var result1=  taskExecutorService.executeTask(taskExecutionRequest);


        TaskExecutionRequest taskExecutionRequest2=new TaskExecutionRequest();

        taskExecutionRequest2.setTaskList(list);
        taskExecutionRequest2.setExecutionType(ExecutionType.SEQUENCIAL);

       var result2= taskExecutorService.executeTask(taskExecutionRequest2);

        System.out.println(result1);
        System.out.println(result2);

    }

}
