package boris.enterprice.infrastructure;

import boris.enterprice.application.task.*;
import boris.enterprice.domain.repository.TaskRepository;
import boris.enterprice.infrastructure.adapters.cli.CLIAdapter;
import boris.enterprice.infrastructure.adapters.repository.json.JsonTaskRepository;

/**
 * Main class to run the application.
 */
public class Main {

    /**
     * Main method to run the application.
     *
     * @param args the arguments to run the application
     */
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
        ListByStatusTaskUseCase listByStatusTaskUseCase = new ListByStatusTaskUseCase(taskRepository);

        CLIAdapter cliAdapter = new CLIAdapter(
                addTaskUseCase,
                listTaskUseCase,
                updateTaskUseCase,
                deleteTaskUseCase,
                updateStatusToProgressTaskUseCase,
                updateStatusToDoneTaskUseCase,
                listByStatusTaskUseCase
        );

        cliAdapter.start();
    }
}