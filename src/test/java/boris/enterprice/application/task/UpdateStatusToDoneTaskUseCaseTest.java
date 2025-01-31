package boris.enterprice.application.task;

import boris.enterprice.domain.model.Task;
import boris.enterprice.domain.repository.TaskRepository;
import boris.enterprice.utils.UtilUUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateStatusToDoneTaskUseCaseTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private UpdateStatusToDoneTaskUseCase updateStatusToDoneTaskUseCase;

    @Test
    @DisplayName("Should update task status to done")
    void shouldUpdateTaskStatusToDone() {
        HashMap<String, String> task = new HashMap<>();
        task.put("status", "DONE");
        task.put("uuid", UtilUUID.getInstance().getStringFromUUID(UtilUUID.getInstance().getNewUUID()));
        when(taskRepository.updateStatus(task.get("status"),task.get("uuid"))).thenReturn(new Task());

        Task result = updateStatusToDoneTaskUseCase.execute(task);

        assertThat(result).isNotNull();
    }
}
