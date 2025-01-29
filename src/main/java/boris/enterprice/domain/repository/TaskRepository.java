package boris.enterprice.domain.repository;

import boris.enterprice.domain.model.Task;
import boris.enterprice.domain.model.enums.TasksStatus;

import java.util.List;

public interface TaskRepository {
    Task save(Task task);
    List<Task> findByStatus(TasksStatus status);
    Task update(String uuid, String description);
    Task updateStatus(String status, String uuid);
    boolean delete(String uuid);
    List<Task> findAll();
}
