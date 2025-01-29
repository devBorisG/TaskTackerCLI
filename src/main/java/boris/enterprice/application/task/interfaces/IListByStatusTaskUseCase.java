package boris.enterprice.application.task.interfaces;

import boris.enterprice.application.IListFilterUseCase;
import boris.enterprice.application.IListUseCase;
import boris.enterprice.domain.model.Task;
import boris.enterprice.domain.model.enums.TasksStatus;

public interface IListByStatusTaskUseCase extends IListFilterUseCase<Task, TasksStatus> {
}
