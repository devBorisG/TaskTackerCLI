package boris.enterprice.application.task;

import boris.enterprice.application.task.interfaces.IUpdateTaskUseCase;
import boris.enterprice.domain.model.Task;
import boris.enterprice.domain.repository.TaskRepository;

import java.util.HashMap;

public class UpdateTaskUseCase implements IUpdateTaskUseCase {

    private final TaskRepository taskRepository;

    public UpdateTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task execute(HashMap<String, String> task) {
        Task taskUpdated  = taskRepository.update(task.get("uuid"), task.get("description"));
        if(taskUpdated == null){
            System.out.println("Task not found");
        }
        return taskUpdated;
    }
}
