package boris.enterprice.application.task;

import boris.enterprice.application.task.interfaces.IListByStatusTaskUseCase;
import boris.enterprice.domain.model.Task;
import boris.enterprice.domain.model.enums.TasksStatus;
import boris.enterprice.domain.repository.TaskRepository;

import java.util.List;

/**
 * Use case for listing tasks by status.
 */
public class ListByStatusTaskUseCase implements IListByStatusTaskUseCase {

    private final TaskRepository taskRepository;

    /**
     * Constructor for ListByStatusTaskUseCase.
     *
     * @param taskRepository the repository to list the tasks
     */
    public ListByStatusTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Executes the use case to list tasks with the given status.
     *
     * @param filter the status to filter the tasks
     * @return the list of tasks with the given status
     */
    @Override
    public List<Task> execute(TasksStatus filter) {
        return taskRepository.findByStatus(filter);
    }
}
