package practice.lld.task_execution_framework;

@FunctionalInterface
public interface Task<R> {
    R execute() throws InterruptedException;
}
