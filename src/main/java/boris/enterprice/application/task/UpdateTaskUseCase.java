package boris.enterprice.application.task;

import boris.enterprice.application.task.interfaces.IUpdateTaskUseCase;
import boris.enterprice.domain.model.Task;
import boris.enterprice.domain.repository.TaskRepository;

import java.util.HashMap;

/**
 * Use case for updating the description of a task.
 */
public class UpdateTaskUseCase implements IUpdateTaskUseCase {

    private final TaskRepository taskRepository;

    /**
     * Constructor for UpdateTaskUseCase.
     *
     * @param taskRepository the repository to update the task
     */
    public UpdateTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Executes the use case to update the description of a task.
     *
     * @param task the task to update
     * @return the updated task
     */
    @Override
    public Task execute(HashMap<String, String> task) {
        Task taskUpdated  = taskRepository.update(task.get("uuid"), task.get("description"));
        if(taskUpdated == null){
            System.out.println("Task not found");
        }
        return taskUpdated;
    }
}
