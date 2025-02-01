package boris.enterprice.application.task;

import boris.enterprice.application.task.interfaces.IUpdateStatusTaskUseCase;
import boris.enterprice.domain.model.Task;
import boris.enterprice.domain.repository.TaskRepository;

import java.util.HashMap;

/**
 * Use case for updating the status of a task to done.
 */
public class UpdateStatusToDoneTaskUseCase implements IUpdateStatusTaskUseCase {

    private final TaskRepository taskRepository;

    /**
     * Constructor for UpdateStatusToDoneTaskUseCase.
     *
     * @param taskRepository the repository to update the task
     */
    public UpdateStatusToDoneTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Executes the use case to update the status of a task to done.
     *
     * @param task the task to update
     * @return the updated task
     */
    @Override
    public Task execute(HashMap<String, String> task) {
        Task taskUpdated  = taskRepository.updateStatus(task.get("status"), task.get("uuid"));
        if(taskUpdated == null){
            System.out.println("Task not found");
        }
        return taskUpdated;
    }
}
