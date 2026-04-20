package practice.lld.task_execution_framework;

import java.util.List;
import java.util.Objects;

public interface TaskExecutionStrategy {

    List<Object> executeTask(List<Task<?>> taskList) throws InterruptedException;
}
