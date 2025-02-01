package boris.enterprice.infrastructure.adapters.cli.commands;

import boris.enterprice.application.task.interfaces.IDeleteTaskUseCase;
import boris.enterprice.infrastructure.adapters.cli.commands.Interface.Command;

/**
 * Command to delete a task.
 */
public class DeleteCommand implements Command {

    private final IDeleteTaskUseCase deleteTaskUseCase;

    /**
     * Constructor for DeleteCommand.
     *
     * @param deleteTaskUseCase the use case to delete a task
     */
    public DeleteCommand(IDeleteTaskUseCase deleteTaskUseCase) {
        this.deleteTaskUseCase = deleteTaskUseCase;
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String getName() {
        return "delete";
    }

    /**
     * Executes the command with the given arguments.
     *
     * @param args the arguments for the command
     */
    @Override
    public void execute(String[] args) {
        if (args.length < 1) {
            System.out.println("Use: task-cli delete <uuid>");
            return;
        }

        String uuid = args[0];

        if(Boolean.TRUE.equals(deleteTaskUseCase.execute(uuid))){
            System.out.println("Task deleted" + " with id: " + uuid);
        }
    }

    /**
     * Gets the help message for the command.
     *
     * @return the help message
     */
    @Override
    public String getHelp() {
        return "task-cli delete <uuid> - Delete a task";
    }
}
