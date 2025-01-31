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
class UpdateStatusToProgressTaskUseCaseTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private UpdateStatusToProgressTaskUseCase updateStatusToProgressTaskUseCase;

    @Test
    @DisplayName("Should update task status to progress")
    void shouldUpdateTaskStatusToProgress() {
        HashMap<String, String> task = new HashMap<>();
        task.put("status", "IN_PROGRESS");
        task.put("uuid", UtilUUID.getInstance().getStringFromUUID(UtilUUID.getInstance().getNewUUID()));
        when(taskRepository.updateStatus(task.get("status"),task.get("uuid"))).thenReturn(new Task());

        Task result = updateStatusToProgressTaskUseCase.execute(task);

        assertThat(result).isNotNull();
    }
}
