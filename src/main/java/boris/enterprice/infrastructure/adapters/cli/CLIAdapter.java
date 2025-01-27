package boris.enterprice.infrastructure.adapters.cli;

import boris.enterprice.application.AddTaskUseCase;
import boris.enterprice.infrastructure.adapters.cli.commands.AddCommand;
import boris.enterprice.infrastructure.adapters.cli.commands.Command;
import boris.enterprice.infrastructure.adapters.cli.commands.ExitCommand;
import boris.enterprice.infrastructure.adapters.cli.commands.HelpCommand;
import boris.enterprice.utils.UtilText;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CLIAdapter {
    private final Map<String, Command> commands = new HashMap<>();

    public CLIAdapter(AddTaskUseCase addTaskUseCase) {
        registerCommand(new AddCommand(addTaskUseCase));
        registerCommand(new HelpCommand(commands));
        registerCommand(new ExitCommand());
    }

    private void registerCommand(Command cmd) {
        commands.put(cmd.getName(), cmd);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("WELCOME!\nEnter a command or type 'help' to see the available commands or 'exit' to exit the application");

        while(true){
            System.out.print("> ");
            String input = UtilText.getInstance().trim(scanner.nextLine());
            if(input.isEmpty()){
                continue;
            }
            String[] parts = input.split("\\s+");

            if(!parts[0].equals("task-cli")){
                System.out.println("Invalid command, type 'help' to see the available commands");
                continue;
            }

            String cmdName = parts[1].toLowerCase();

            String[] cmdArgs = new String[parts.length - 2];
            System.arraycopy(parts, 2, cmdArgs, 0, cmdArgs.length );

            Command cmd = commands.get(cmdName);
            if (cmd == null) {
                System.out.println("Invalid command"+ cmdName +", type 'help' to see the available commands");
                continue;
            }

            cmd.execute(cmdArgs);
        }
    }
}
