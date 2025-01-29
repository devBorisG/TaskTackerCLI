package boris.enterprice.infrastructure.adapters.cli.commands.Interface;

public interface Command {
    String getName();
    void execute(String[] args);
    String getHelp();
}
