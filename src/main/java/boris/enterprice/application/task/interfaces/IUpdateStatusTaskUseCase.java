package boris.enterprice.application.task.interfaces;

import boris.enterprice.application.IObjectUseCase;
import boris.enterprice.domain.model.Task;

import java.util.HashMap;

public interface IUpdateStatusTaskUseCase extends IObjectUseCase<Task, HashMap<String,String>> {
}
