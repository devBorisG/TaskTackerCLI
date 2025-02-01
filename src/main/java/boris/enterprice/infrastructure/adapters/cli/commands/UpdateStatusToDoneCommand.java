package boris.enterprice.infrastructure.adapters.cli.commands;

import boris.enterprice.application.task.interfaces.IUpdateStatusTaskUseCase;
import boris.enterprice.domain.model.enums.TasksStatus;
import boris.enterprice.infrastructure.adapters.cli.commands.Interface.Command;

import java.util.HashMap;

/**
 * Command to update the status of a task to done.
 */
public class UpdateStatusToDoneCommand implements Command {

    private final IUpdateStatusTaskUseCase updateStatusToDoneTaskUseCase;

    /**
     * Constructor for UpdateStatusToDoneCommand.
     *
     * @param updateStatusToDoneTaskUseCase the use case to update the status of a task to done
     */
    public UpdateStatusToDoneCommand(IUpdateStatusTaskUseCase updateStatusToDoneTaskUseCase) {
        this.updateStatusToDoneTaskUseCase = updateStatusToDoneTaskUseCase;
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String getName() {
        return "mark-done";
    }

    /**
     * Executes the command with the given arguments.
     *
     * @param args the arguments for the command
     */
    @Override
    public void execute(String[] args) {
        if(args.length < 1){
            System.out.println("Use: task-cli mark-done <uuid>");
            return;
        }

        String uuid = args[0];
        HashMap<String, String> task = new HashMap<>();
        task.put("status", TasksStatus.DONE.toString());
        task.put("uuid", uuid);

        updateStatusToDoneTaskUseCase.execute(task);
        System.out.println("Task updated" + " with id: " + uuid + " and status: " + TasksStatus.DONE);
    }

    /**
     * Gets the help message for the command.
     *
     * @return the help message
     */
    @Override
    public String getHelp() {
        return "task-cli mark-done <uuid> - Mark a task as done";
    }
}
