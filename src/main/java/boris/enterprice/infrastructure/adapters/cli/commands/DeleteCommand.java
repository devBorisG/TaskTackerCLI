package boris.enterprice.infrastructure.adapters.cli.commands;

import boris.enterprice.application.task.interfaces.IDeleteTaskUseCase;
import boris.enterprice.infrastructure.adapters.cli.commands.Interface.Command;

public class DeleteCommand implements Command {

    private final IDeleteTaskUseCase deleteTaskUseCase;

    public DeleteCommand(IDeleteTaskUseCase deleteTaskUseCase) {
        this.deleteTaskUseCase = deleteTaskUseCase;
    }

    @Override
    public String getName() {
        return "delete";
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 1) {
            System.out.println("Use: task-cli delete <uuid>");
            return;
        }

        String uuid = args[0];

        if(deleteTaskUseCase.execute(uuid)){
            System.out.println("Task deleted" + " with id: " + uuid);
        }
    }

    @Override
    public String getHelp() {
        return "task-cli delete <uuid> - Delete a task";
    }
}
