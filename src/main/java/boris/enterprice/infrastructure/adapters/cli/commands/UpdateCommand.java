package boris.enterprice.infrastructure.adapters.cli.commands;

import boris.enterprice.application.task.interfaces.IUpdateTaskUseCase;
import boris.enterprice.infrastructure.adapters.cli.commands.Interface.Command;
import boris.enterprice.utils.UtilText;

import java.util.HashMap;

public class UpdateCommand implements Command {

    private final IUpdateTaskUseCase updateTaskUseCase;

    public UpdateCommand(IUpdateTaskUseCase updateTaskUseCase) {
        this.updateTaskUseCase = updateTaskUseCase;
    }

    @Override
    public String getName() {
        return "update";
    }

    @Override
    public void execute(String[] args) {
        if(args.length < 2){
            System.out.println("Use: task-cli update <uuid> <description>");
            return;
        }

        String uuid = args[0];
        String description = args[1];
        HashMap<String, String> task = new HashMap<>();
        task.put("uuid", uuid);
        task.put("description", description);

        if (UtilText.getInstance().validMatch(description, "^\"[^\"]*\"$")) {
            updateTaskUseCase.execute(task);
            System.out.println("Task updated" + " with id: " + uuid + " and description: " + description);
        }else{
            System.out.println("Description must be in quotes");
        }
    }

    @Override
    public String getHelp() {
        return "task-cli update - Update a task";
    }
}
