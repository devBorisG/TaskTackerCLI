package boris.enterprice.infrastructure;

import boris.enterprice.application.AddTaskUseCase;
import boris.enterprice.domain.repository.TaskRepository;
import boris.enterprice.infrastructure.adapters.cli.CLIAdapter;
import boris.enterprice.infrastructure.adapters.repository.json.JsonTaskRepository;

public class Main {
    public static void main(String[] args) {
        String filepath = "tasks.json";

        TaskRepository taskRepository = new JsonTaskRepository(filepath);
        AddTaskUseCase addTaskUseCase = new AddTaskUseCase(taskRepository);
        CLIAdapter cliAdapter = new CLIAdapter(addTaskUseCase);

        cliAdapter.start();
    }
}