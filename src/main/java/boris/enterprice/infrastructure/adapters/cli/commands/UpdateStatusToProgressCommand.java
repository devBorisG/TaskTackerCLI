package boris.enterprice.infrastructure.adapters.cli.commands;

import boris.enterprice.application.task.interfaces.IUpdateStatusTaskUseCase;
import boris.enterprice.domain.model.enums.TasksStatus;
import boris.enterprice.infrastructure.adapters.cli.commands.Interface.Command;

import java.util.HashMap;

public class UpdateStatusToProgressCommand implements Command {

    private final IUpdateStatusTaskUseCase updateStatusTaskUseCase;

    public UpdateStatusToProgressCommand(IUpdateStatusTaskUseCase updateStatusTaskUseCase) {
        this.updateStatusTaskUseCase = updateStatusTaskUseCase;
    }

    @Override
    public String getName() {
        return "mark-in-progress";
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 1) {
            System.out.println("Use: task-cli mark-in-progress <uuid>");
            return;
        }

        String uuid = args[0];
        HashMap<String, String> task = new HashMap<>();
        task.put("status",TasksStatus.IN_PROGRESS.toString());
        task.put("uuid", uuid);

        updateStatusTaskUseCase.execute(task);
        System.out.println("Task updated" + " with id: " + uuid + " and status: " + TasksStatus.IN_PROGRESS);
    }

    @Override
    public String getHelp() {
        return "task-cli mark-in-progress <uuid> - Mark a task as in progress";
    }
}
