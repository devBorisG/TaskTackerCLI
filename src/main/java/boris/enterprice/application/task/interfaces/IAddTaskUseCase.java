package boris.enterprice.application.task.interfaces;

import boris.enterprice.application.IObjectUseCase;
import boris.enterprice.domain.model.Task;

/**
 * Interface for the use case to add a new task.
 */
public interface IAddTaskUseCase extends IObjectUseCase<Task,String> {
}
