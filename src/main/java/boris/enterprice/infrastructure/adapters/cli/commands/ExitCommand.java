package boris.enterprice.infrastructure.adapters.cli.commands;

public class ExitCommand implements Command{
    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Exiting the application...");
        System.exit(0);
    }

    @Override
    public String getHelp() {
        return "exit - Exit the application";
    }
}
