package practice.lld.task_execution_framework;

import java.util.List;

public class TaskExecutorService {

   private TaskExecutionStrategy taskExecutionStrategy;

   List<Object> executeTask(TaskExecutionRequest taskExecutionRequest) throws InterruptedException {
      taskExecutionStrategy= TaskExecutionStrategyFactory.getStrategy(taskExecutionRequest.getExecutionType());
      return taskExecutionStrategy.executeTask(taskExecutionRequest.getTaskList());
   }
}
