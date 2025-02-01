package boris.enterprice.infrastructure.adapters.cli;

import boris.enterprice.application.task.*;
import boris.enterprice.infrastructure.adapters.cli.commands.*;
import boris.enterprice.infrastructure.adapters.cli.commands.Interface.Command;
import boris.enterprice.utils.UtilText;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Adapter for the CLI.
 */
public class CLIAdapter {
    private final Map<String, Command> commands = new HashMap<>();

    /**
     * Constructor for CLIAdapter.
     *
     * @param addTaskUseCase the use case to add a task
     * @param listTaskUseCase the use case to list tasks
     * @param updateTaskUseCase the use case to update a task
     * @param deleteTaskUseCase the use case to delete a task
     * @param updateStatusToProgressTaskUseCase the use case to update the status of a task to in progress
     * @param updateStatusToDoneTaskUseCase the use case to update the status of a task to done
     * @param listByStatusTaskUseCase the use case to list tasks by status
     */
    public CLIAdapter(AddTaskUseCase addTaskUseCase,
                      ListTaskUseCase listTaskUseCase,
                      UpdateTaskUseCase updateTaskUseCase,
                      DeleteTaskUseCase deleteTaskUseCase,
                      UpdateStatusToProgressTaskUseCase updateStatusToProgressTaskUseCase,
                      UpdateStatusToDoneTaskUseCase updateStatusToDoneTaskUseCase,
                      ListByStatusTaskUseCase listByStatusTaskUseCase
                      ) {
        registerCommand(new AddCommand(addTaskUseCase));
        registerCommand(new ListCommand(listTaskUseCase));
        registerCommand(new UpdateCommand(updateTaskUseCase));
        registerCommand(new DeleteCommand(deleteTaskUseCase));
        registerCommand(new UpdateStatusToProgressCommand(updateStatusToProgressTaskUseCase));
        registerCommand(new UpdateStatusToDoneCommand(updateStatusToDoneTaskUseCase));
        registerCommand(new ListByStatusCommand(listByStatusTaskUseCase));
        registerCommand(new HelpCommand(commands));
        registerCommand(new ExitCommand());
    }

    /**
     * Registers a command.
     *
     * @param cmd the command to register
     */
    private void registerCommand(Command cmd) {
        commands.put(cmd.getName(), cmd);
    }

    /**
     * Starts the CLI.
     */
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

            if(!parts[0].equals("task-cli") && !parts[0].equals("help") && !parts[0].equals("exit")){
                System.out.println("Invalid command, type 'help' to see the available commands");
                continue;
            }

            String cmdName = parts[0].equals("help") ? "help" : parts[0].equals("exit") ? "exit" : parts[1].toLowerCase();

            String[] cmdArgs = new String[1];

            if((!cmdName.equals("list-all") && !cmdName.equals("help") && !cmdName.equals("exit")) || (cmdName.equals("list") && parts.length > 2)){
                cmdArgs = new String[parts.length - 2];
                System.arraycopy(parts, 2, cmdArgs, 0, cmdArgs.length );
            }

            Command cmd = commands.get(cmdName);
            if (cmd == null) {
                System.out.println("Invalid command "+ cmdName +", type 'help' to see the available commands");
                continue;
            }

            cmd.execute(cmdArgs);
        }
    }
}
