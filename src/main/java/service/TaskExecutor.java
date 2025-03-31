package service;

import model.Task;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

/**
 * This Java class resembles a TaskExecutor
 * @author adityakrishnan
 */
public class TaskExecutor {

    /**
     * scheduleTasks() function
     * @param incomingTasks List of Task
     * @return listOfCompletedTasks - List of Task
     */
    public static List<Task> scheduleTasks(List<Task> incomingTasks) {
        try {
            Instant startTime = Instant.now();
            PriorityQueue<Task> taskQueue = new PriorityQueue<>(
                    Comparator.comparing(Task::getTaskPriority)
                            .thenComparing(Task::getDeadlineForCompletion)
            );
            taskQueue.addAll(incomingTasks);

            List<Task> completedTasks = new ArrayList<>();

            while (!taskQueue.isEmpty()) {
                Task currentTask;
                synchronized (taskQueue) {
                    currentTask = taskQueue.poll();
                }
                if (currentTask == null) {
                    break;
                }

                long endTime = Duration.between(startTime, Instant.now()).toSeconds();
                long timePassed = endTime + currentTask.getEstimatedTimeToCompletion();

                synchronized (TaskExecutor.class) {
                    if (timePassed + currentTask.getEstimatedTimeToCompletion() <= currentTask.getDeadlineForCompletion()) {
                        try {
                            Thread.sleep(currentTask.getEstimatedTimeToCompletion() * 1000L);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        completedTasks.add(currentTask);
                    }
                }

            }

            return completedTasks;
        } catch (Exception error) {
            System.out.println(error);
            return new ArrayList<>();
        }
    }

}
