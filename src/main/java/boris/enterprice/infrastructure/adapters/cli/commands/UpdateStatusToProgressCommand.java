package boris.enterprice.infrastructure.adapters.cli.commands;

import boris.enterprice.application.task.interfaces.IUpdateStatusTaskUseCase;
import boris.enterprice.domain.model.enums.TasksStatus;
import boris.enterprice.infrastructure.adapters.cli.commands.Interface.Command;

import java.util.HashMap;

/**
 * Command to update the status of a task to in progress.
 */
public class UpdateStatusToProgressCommand implements Command {

    private final IUpdateStatusTaskUseCase updateStatusTaskUseCase;

    /**
     * Constructor for UpdateStatusToProgressCommand.
     *
     * @param updateStatusTaskUseCase the use case to update the status of a task to in progress
     */
    public UpdateStatusToProgressCommand(IUpdateStatusTaskUseCase updateStatusTaskUseCase) {
        this.updateStatusTaskUseCase = updateStatusTaskUseCase;
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String getName() {
        return "mark-in-progress";
    }

    /**
     * Executes the command with the given arguments.
     *
     * @param args the arguments for the command
     */
    @Override
    public void execute(String[] args) {
        if (args.length < 1) {
            System.out.println("Use: task-cli mark-in-progress <uuid>");
            return;
        }

        String uuid = args[0];
        HashMap<String, String> task = new HashMap<>();
        task.put("status",TasksStatus.IN_PROGRESS.toString());
        task.put("uuid", uuid);

        updateStatusTaskUseCase.execute(task);
        System.out.println("Task updated" + " with id: " + uuid + " and status: " + TasksStatus.IN_PROGRESS);
    }

    /**
     * Gets the help message for the command.
     *
     * @return the help message
     */
    @Override
    public String getHelp() {
        return "task-cli mark-in-progress <uuid> - Mark a task as in progress";
    }
}
