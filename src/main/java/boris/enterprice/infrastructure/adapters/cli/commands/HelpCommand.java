package boris.enterprice.infrastructure.adapters.cli.commands;

import boris.enterprice.infrastructure.adapters.cli.commands.Interface.Command;

import java.util.Map;

/**
 * Command to show help for all commands available.
 */
public class HelpCommand implements Command {

    private final Map<String, Command> commands;

    /**
     * Constructor for HelpCommand.
     *
     * @param commands the commands available
     */
    public HelpCommand(Map<String, Command> commands) {
        this.commands = commands;
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String getName() {
        return "help";
    }

    /**
     * Executes the command with the given arguments.
     *
     * @param args the arguments for the command
     */
    @Override
    public void execute(String[] args) {
        System.out.println("Commands available:");
        for (Command cmd: commands.values()){
            System.out.println(cmd.getName() + " - " + cmd.getHelp());
        }
    }

    /**
     * Gets the help message for the command.
     *
     * @return the help message
     */
    @Override
    public String getHelp() {
        return "help - Show help for all commands available";
    }
}
