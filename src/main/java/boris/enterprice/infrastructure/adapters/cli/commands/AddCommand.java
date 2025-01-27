package boris.enterprice.infrastructure.adapters.cli.commands;

import boris.enterprice.application.task.interfaces.IAddTaskUseCase;
import boris.enterprice.domain.model.Task;
import boris.enterprice.utils.UtilText;

public class AddCommand implements Command{

    private final IAddTaskUseCase addTaskUseCase;

    public AddCommand(IAddTaskUseCase addTaskUseCase) {
        this.addTaskUseCase = addTaskUseCase;
    }

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 1) {
            System.out.println("Use: task-cli add <description>");
            return;
        }
        String description = args[0];
        System.out.println(description);

        if (UtilText.getInstance().validMatch(description, "^\"[^\"]*\"$")) {
            Task task = addTaskUseCase.execute(description);
            System.out.println("Task: "+ task.getDescription() + " added " + " with id: " + task.getId());
        } else {
            System.out.println("Description is empty");
        }
    }

    @Override
    public String getHelp() {
        return "task-cli add <description> - Add a new task with the description designated";
    }
}
