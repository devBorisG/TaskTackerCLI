package boris.enterprice.infrastructure.adapters.cli.commands;

import boris.enterprice.application.task.interfaces.IListByStatusTaskUseCase;
import boris.enterprice.domain.model.Table;
import boris.enterprice.domain.model.Task;
import boris.enterprice.domain.model.enums.TasksStatus;
import boris.enterprice.infrastructure.adapters.cli.commands.Interface.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Command to list tasks by status.
 */
public class ListByStatusCommand implements Command {

    private final IListByStatusTaskUseCase listTaskUseCase;

    /**
     * Constructor for ListByStatusCommand.
     *
     * @param listTaskUseCase the use case to list tasks by status
     */
    public ListByStatusCommand(IListByStatusTaskUseCase listTaskUseCase) {
        this.listTaskUseCase = listTaskUseCase;
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String getName() {
        return "list";
    }

    /**
     * Executes the command with the given arguments.
     *
     * @param args the arguments for the command
     */
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

    /**
     * Gets the help message for the command.
     *
     * @return the help message
     */
    @Override
    public String getHelp() {
        return "task-cli list <status> - List all tasks by status";
    }
}
