package boris.enterprice.infrastructure.adapters.cli.commands;

import boris.enterprice.application.task.interfaces.IListTaskUseCase;
import boris.enterprice.domain.model.Table;
import boris.enterprice.domain.model.Task;
import boris.enterprice.infrastructure.adapters.cli.commands.Interface.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Command to list all tasks.
 */
public class ListCommand implements Command {

    private final IListTaskUseCase listTaskUseCase;

    /**
     * Constructor for ListCommand.
     *
     * @param listTaskUseCase the use case to list all tasks
     */
    public ListCommand(IListTaskUseCase listTaskUseCase) {
        this.listTaskUseCase = listTaskUseCase;
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String getName() {
        return "list-all";
    }

    /**
     * Executes the command with the given arguments.
     *
     * @param args the arguments for the command
     */
    @Override
    public void execute(String[] args) {
        if(args.length < 1){
            System.out.println("Use: task-cli list");
            return;
        }

        List<Task> tasks = listTaskUseCase.execute();
        List<String> headers = List.of("Description", "Id", "Created At", "Updated At", "Status");
        List<List<String>> rows = new ArrayList<>();

        for(Task task: tasks) {
            rows.add(List.of(
                    task.getDescription().replace("\"", ""),
                    task.getId().toString(),
                    task.getCreatedAt().toString(),
                    task.getUpdatedAt().toString(),
                    task.getStatus().toString()
            ));
        }

        Table table = new Table(headers, rows);
        table.print();
    }

    /**
     * Gets the help message for the command.
     *
     * @return the help message
     */
    @Override
    public String getHelp() {
        return "task-cli list-all - List all tasks";
    }
}
