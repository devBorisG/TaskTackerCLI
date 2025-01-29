package boris.enterprice.application.task;

import boris.enterprice.application.task.interfaces.IDeleteTaskUseCase;
import boris.enterprice.domain.repository.TaskRepository;

public class DeleteTaskUseCase implements IDeleteTaskUseCase {

    private final TaskRepository taskRepository;

    public DeleteTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

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
