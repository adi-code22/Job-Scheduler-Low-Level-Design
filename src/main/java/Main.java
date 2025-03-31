import model.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static service.TaskExecutor.scheduleTasks;

/**
 * Main method
 * @author adityakrishnan
 */
public class Main {

    public static void main(String[] args) {
        List<Task> tasks = Arrays.asList(
                new Task(UUID.randomUUID().toString(), 2, 4, 10),
                new Task(UUID.randomUUID().toString(), 1, 2, 5),
                new Task(UUID.randomUUID().toString(), 3, 3, 7),
                new Task(UUID.randomUUID().toString(), 1, 1, 3),
                new Task(UUID.randomUUID().toString(), 2, 2, 6)
        );

        // TODO: Add tasks to the list whenever a task is completed
        List<Task> completedTaskList = scheduleTasks(tasks);

        for (Task completedTask: completedTaskList) {
            System.out.println(completedTask.toString());
        }
    }
}
