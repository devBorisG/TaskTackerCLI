package boris.enterprice.application.task;

import boris.enterprice.application.task.interfaces.IListTaskUseCase;
import boris.enterprice.domain.model.Task;
import boris.enterprice.domain.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class ListTaskUseCase implements IListTaskUseCase {

    private final TaskRepository taskRepository;

    public ListTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> execute() {
        return new ArrayList<>(taskRepository.findAll());
    }
}
