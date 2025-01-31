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
class UpdateTaskUseCaseTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private UpdateTaskUseCase updateTaskUseCase;

    @Test
    @DisplayName("Should update task")
    void shouldUpdateTask() {
        HashMap<String, String> task = new HashMap<>();
        task.put("description", "Test_description");
        task.put("uuid", UtilUUID.getInstance().getStringFromUUID(UtilUUID.getInstance().getNewUUID()));
        when(taskRepository.update(task.get("uuid"), task.get("description"))).thenReturn(new Task());

        Task result = updateTaskUseCase.execute(task);

        assertThat(result).isNotNull();
    }
}
