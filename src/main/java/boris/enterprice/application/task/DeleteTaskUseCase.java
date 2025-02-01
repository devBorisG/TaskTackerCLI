package boris.enterprice.application.task;

import boris.enterprice.application.task.interfaces.IDeleteTaskUseCase;
import boris.enterprice.domain.repository.TaskRepository;

/**
 * Use case for deleting a task.
 */
public class DeleteTaskUseCase implements IDeleteTaskUseCase {

    private final TaskRepository taskRepository;

    /**
     * Constructor for DeleteTaskUseCase.
     *
     * @param taskRepository the repository to delete the task
     */
    public DeleteTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Executes the use case to delete a task with the given id.
     *
     * @param object the id of the task to delete
     * @return true if the task was deleted, false otherwise
     */
    @Override
    public Boolean execute(String object) {
        if(taskRepository.delete(object)){
            return true;
        }else {
            System.out.println("Task not found");
            return false;
        }
    }
}
