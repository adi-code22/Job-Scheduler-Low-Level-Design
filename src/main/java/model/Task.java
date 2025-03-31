package model;

/**
 * This Java class represents a Task
 * @author adityakrishnan
 */
public class Task {

    private String uniqueId;

    private int taskPriority;

    private int estimatedTimeToCompletion;

    private int deadlineForCompletion;

    public Task(String uniqueId, int taskPriority, int estimatedTimeToCompletion, int deadlineForCompletion) {
        this.uniqueId = uniqueId;
        this.taskPriority = taskPriority;
        this.estimatedTimeToCompletion = estimatedTimeToCompletion;
        this.deadlineForCompletion = deadlineForCompletion;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public int getTaskPriority() {
        return taskPriority;
    }

    public int getEstimatedTimeToCompletion() {
        return estimatedTimeToCompletion;
    }

    public int getDeadlineForCompletion() {
        return deadlineForCompletion;
    }

    @Override
    public String toString() {
        return "Task{" +
                "uniqueId='" + uniqueId + '\'' +
                ", taskPriority=" + taskPriority +
                ", estimatedTimeToCompletion=" + estimatedTimeToCompletion +
                ", deadlineForCompletion=" + deadlineForCompletion +
                '}';
    }
}
