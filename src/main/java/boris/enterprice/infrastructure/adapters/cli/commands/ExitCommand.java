package boris.enterprice.infrastructure.adapters.cli.commands;

import boris.enterprice.infrastructure.adapters.cli.commands.Interface.Command;

/**
 * Command to exit the application.
 */
public class ExitCommand implements Command {

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String getName() {
        return "exit";
    }

    /**
     * Executes the command with the given arguments.
     *
     * @param args the arguments for the command
     */
    @Override
    public void execute(String[] args) {
        System.out.println("Exiting the application...");
        System.exit(0);
    }

    /**
     * Gets the help message for the command.
     *
     * @return the help message
     */
    @Override
    public String getHelp() {
        return "exit - Exit the application";
    }
}
