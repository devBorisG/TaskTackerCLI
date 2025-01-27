package boris.enterprice.infrastructure.adapters.cli.commands;

import java.util.Map;

public class HelpCommand implements Command{

    private final Map<String, Command> commands;

    public HelpCommand(Map<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Commands available:");
        for (Command cmd: commands.values()){
            System.out.println(cmd.getName() + " - " + cmd.getHelp());
        }
    }

    @Override
    public String getHelp() {
        return "help - Show help for all commands available";
    }
}
