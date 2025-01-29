package boris.enterprice.application.task;

import boris.enterprice.application.task.interfaces.IListByStatusTaskUseCase;
import boris.enterprice.domain.model.Task;
import boris.enterprice.domain.model.enums.TasksStatus;
import boris.enterprice.domain.repository.TaskRepository;

import java.util.List;

public class ListByStatusTaskUseCase implements IListByStatusTaskUseCase {

    private final TaskRepository taskRepository;

    public ListByStatusTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> execute(TasksStatus filter) {
        return taskRepository.findByStatus(filter);
    }
}
