package boris.enterprice.infrastructure.adapters.cli.commands;

import boris.enterprice.application.task.UpdateStatusToDoneTaskUseCase;
import boris.enterprice.application.task.interfaces.IUpdateStatusTaskUseCase;
import boris.enterprice.domain.model.enums.TasksStatus;
import boris.enterprice.infrastructure.adapters.cli.commands.Interface.Command;

import java.util.HashMap;

public class UpdateStatusToDoneCommand implements Command {

    private final IUpdateStatusTaskUseCase updateStatusToDoneTaskUseCase;

    public UpdateStatusToDoneCommand(IUpdateStatusTaskUseCase updateStatusToDoneTaskUseCase) {
        this.updateStatusToDoneTaskUseCase = updateStatusToDoneTaskUseCase;
    }

    @Override
    public String getName() {
        return "mark-done";
    }

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

    @Override
    public String getHelp() {
        return "task-cli mark-done <uuid> - Mark a task as done";
    }
}
