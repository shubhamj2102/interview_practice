package practice.lld.task_execution_framework;

public class TaskExecutionStrategyFactory {

    public static TaskExecutionStrategy getStrategy(ExecutionType executionType){

        if(ExecutionType.SEQUENCIAL.equals(executionType)){
            return new SequenceExecutionStrategy();
        }
        return new ParallelExecutionStrategy();
    }
}
