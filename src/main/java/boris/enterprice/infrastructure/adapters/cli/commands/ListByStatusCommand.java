package boris.enterprice.infrastructure.adapters.cli.commands;

import boris.enterprice.application.task.interfaces.IListByStatusTaskUseCase;
import boris.enterprice.application.task.interfaces.IListTaskUseCase;
import boris.enterprice.domain.model.Table;
import boris.enterprice.domain.model.Task;
import boris.enterprice.domain.model.enums.TasksStatus;
import boris.enterprice.infrastructure.adapters.cli.commands.Interface.Command;

import java.util.ArrayList;
import java.util.List;

public class ListByStatusCommand implements Command {

    private final IListByStatusTaskUseCase listTaskUseCase;

    public ListByStatusCommand(IListByStatusTaskUseCase listTaskUseCase) {
        this.listTaskUseCase = listTaskUseCase;
    }

    @Override
    public String getName() {
        return "list";
    }

    @Override
    public void execute(String[] args) {
        if(args.length < 1){
            System.out.println("Use: task-cli list <status>");
            return;
        }
        String status = args[0];
        TasksStatus tasksStatus = null;

        switch (status) {
            case "todo":
                tasksStatus = TasksStatus.TODO;
                break;
            case "in-progress":
                tasksStatus = TasksStatus.IN_PROGRESS;
                break;
            case "done":
                tasksStatus = TasksStatus.DONE;
                break;
            default:
                System.out.println("Invalid status");
                break;
        }

        if(tasksStatus != null){
            System.out.println("Tasks by status: " + status);
            List<Task> tasks = listTaskUseCase.execute(tasksStatus);
            List<String> headers = List.of("Description", "Id", "Created At", "Updated At");
            List<List<String>> rows = new ArrayList<>();

            for (Task task: tasks){
                rows.add(List.of(
                        task.getDescription().replace("\"", ""),
                        task.getId().toString(),
                        task.getCreatedAt().toString(),
                        task.getUpdatedAt().toString()
                ));
            }

            Table table = new Table(headers, rows);
            table.print();
        }

    }

    @Override
    public String getHelp() {
        return "task-cli list <status> - List all tasks by status";
    }
}
