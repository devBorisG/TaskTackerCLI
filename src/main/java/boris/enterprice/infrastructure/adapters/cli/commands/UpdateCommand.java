package boris.enterprice.infrastructure.adapters.cli.commands;

import boris.enterprice.application.task.interfaces.IUpdateTaskUseCase;
import boris.enterprice.infrastructure.adapters.cli.commands.Interface.Command;
import boris.enterprice.utils.UtilText;

import java.util.HashMap;

/**
 * Command to update a task.
 */
public class UpdateCommand implements Command {

    private final IUpdateTaskUseCase updateTaskUseCase;

    /**
     * Constructor for UpdateCommand.
     *
     * @param updateTaskUseCase the use case to update a task
     */
    public UpdateCommand(IUpdateTaskUseCase updateTaskUseCase) {
        this.updateTaskUseCase = updateTaskUseCase;
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String getName() {
        return "update";
    }

    /**
     * Executes the command with the given arguments.
     *
     * @param args the arguments for the command
     */
    @Override
    public void execute(String[] args) {
        if(args.length < 2){
            System.out.println("Use: task-cli update <uuid> <description>");
            return;
        }

        String uuid = args[0];
        String description = args[1];
        HashMap<String, String> task = new HashMap<>();
        task.put("uuid", uuid);
        task.put("description", description);

        if (UtilText.getInstance().validMatch(description, "^\"[^\"]*\"$")) {
            updateTaskUseCase.execute(task);
            System.out.println("Task updated" + " with id: " + uuid + " and description: " + description);
        }else{
            System.out.println("Description must be in quotes");
        }
    }

    /**
     * Gets the help message for the command.
     *
     * @return the help message
     */
    @Override
    public String getHelp() {
        return "task-cli update - Update a task";
    }
}
