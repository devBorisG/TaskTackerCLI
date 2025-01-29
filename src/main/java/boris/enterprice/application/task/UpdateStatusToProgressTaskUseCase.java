package boris.enterprice.application.task;

import boris.enterprice.application.task.interfaces.IUpdateStatusTaskUseCase;
import boris.enterprice.domain.model.Task;
import boris.enterprice.domain.model.enums.TasksStatus;
import boris.enterprice.domain.repository.TaskRepository;

import java.util.HashMap;

public class UpdateStatusToProgressTaskUseCase implements IUpdateStatusTaskUseCase {

    private final TaskRepository taskRepository;

    public UpdateStatusToProgressTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task execute(HashMap<String, String> task) {
        Task taskUpdated  = taskRepository.updateStatus(task.get("status"), task.get("uuid"));
        if(taskUpdated == null){
            System.out.println("Task not found");
        }
        return taskUpdated;
    }
}
