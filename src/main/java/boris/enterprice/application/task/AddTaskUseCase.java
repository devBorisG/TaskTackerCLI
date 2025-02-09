package boris.enterprice.application.task;

import boris.enterprice.application.task.interfaces.IAddTaskUseCase;
import boris.enterprice.domain.model.Task;
import boris.enterprice.domain.model.enums.TasksStatus;
import boris.enterprice.domain.repository.TaskRepository;
import boris.enterprice.utils.UtilUUID;

import java.util.Date;
import java.util.UUID;

/**
 * Use case for adding a new task.
 */
public class AddTaskUseCase implements IAddTaskUseCase {
    private final TaskRepository taskRepository;

    /**
     * Constructor for AddTaskUseCase.
     *
     * @param taskRepository the repository to save the task
     */
    public AddTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Executes the use case to add a new task with the given description.
     *
     * @param description the description of the new task
     * @return the saved task
     */
    @Override
    public Task execute(String description) {
        UUID uuid = UtilUUID.getInstance().getNewUUID();
        Task task = new Task(
                uuid,
                description,
                TasksStatus.TODO,
                new Date(),
                new Date(0)
        );
        return taskRepository.save(task);
    }
}
