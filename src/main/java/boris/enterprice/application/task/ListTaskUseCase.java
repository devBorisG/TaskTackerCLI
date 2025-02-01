package boris.enterprice.application.task;

import boris.enterprice.application.task.interfaces.IListTaskUseCase;
import boris.enterprice.domain.model.Task;
import boris.enterprice.domain.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Use case for listing all tasks.
 */
public class ListTaskUseCase implements IListTaskUseCase {

    private final TaskRepository taskRepository;

    /**
     * Constructor for ListTaskUseCase.
     *
     * @param taskRepository the repository to list the tasks
     */
    public ListTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Executes the use case to list all tasks.
     *
     * @return the list of all tasks
     */
    @Override
    public List<Task> execute() {
        return new ArrayList<>(taskRepository.findAll());
    }
}
