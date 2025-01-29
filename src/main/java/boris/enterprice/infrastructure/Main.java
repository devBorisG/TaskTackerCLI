package boris.enterprice.infrastructure;

import boris.enterprice.application.task.*;
import boris.enterprice.domain.repository.TaskRepository;
import boris.enterprice.infrastructure.adapters.cli.CLIAdapter;
import boris.enterprice.infrastructure.adapters.repository.json.JsonTaskRepository;

public class Main {
    public static void main(String[] args) {
        String filepath = "tasks.json";

        TaskRepository taskRepository = new JsonTaskRepository(filepath);

        // UseCase
        AddTaskUseCase addTaskUseCase = new AddTaskUseCase(taskRepository);
        ListTaskUseCase listTaskUseCase = new ListTaskUseCase(taskRepository);
        UpdateTaskUseCase updateTaskUseCase = new UpdateTaskUseCase(taskRepository);
        DeleteTaskUseCase deleteTaskUseCase = new DeleteTaskUseCase(taskRepository);
        UpdateStatusToDoneTaskUseCase updateStatusToDoneTaskUseCase = new UpdateStatusToDoneTaskUseCase(taskRepository);
        UpdateStatusToProgressTaskUseCase updateStatusToProgressTaskUseCase = new UpdateStatusToProgressTaskUseCase(taskRepository);

        CLIAdapter cliAdapter = new CLIAdapter(
                addTaskUseCase,
                listTaskUseCase,
                updateTaskUseCase,
                deleteTaskUseCase,
                updateStatusToProgressTaskUseCase,
                updateStatusToDoneTaskUseCase
        );

        cliAdapter.start();
    }
}