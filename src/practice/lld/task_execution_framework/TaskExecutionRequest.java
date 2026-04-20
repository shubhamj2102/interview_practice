package practice.lld.task_execution_framework;

import java.util.List;

public class TaskExecutionRequest {

  private   List<Task<?>> taskList;
   private ExecutionType executionType;

    public List<Task<?>> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task<?>> taskList) {
        this.taskList = taskList;
    }

    public ExecutionType getExecutionType() {
        return executionType;
    }

    public void setExecutionType(ExecutionType executionType) {
        this.executionType = executionType;
    }
}
