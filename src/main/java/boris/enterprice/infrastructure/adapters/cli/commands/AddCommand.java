package boris.enterprice.infrastructure.adapters.cli.commands;

import boris.enterprice.application.task.interfaces.IAddTaskUseCase;
import boris.enterprice.domain.model.Task;
import boris.enterprice.infrastructure.adapters.cli.commands.Interface.Command;
import boris.enterprice.utils.UtilText;


/**
 * Command to add a new task.
 */
public class AddCommand implements Command {

    private final IAddTaskUseCase addTaskUseCase;

    /**
     * Constructor for AddCommand.
     *
     * @param addTaskUseCase the use case to add a new task
     */
    public AddCommand(IAddTaskUseCase addTaskUseCase) {
        this.addTaskUseCase = addTaskUseCase;
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String getName() {
        return "add";
    }

    /**
     * Executes the command with the given arguments.
     *
     * @param args the arguments for the command
     */
    @Override
    public void execute(String[] args) {
        if (args.length < 1) {
            System.out.println("Use: task-cli add <description>");
            return;
        }
        String description = args[0];

        if (UtilText.getInstance().validMatch(description, "^\"[^\"]*\"$")) {
            Task task = addTaskUseCase.execute(description);
            System.out.println("Task: "+ task.getDescription() + " added " + " with id: " + task.getId());
        } else {
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
        return "task-cli add <description> - Add a new task with the description designated";
    }
}
