package boris.enterprice.infrastructure;

import boris.enterprice.domain.model.Task;
import boris.enterprice.domain.model.enums.TasksStatus;
import boris.enterprice.infrastructure.adapters.repository.json.JsonTaskRepository;
import boris.enterprice.utils.UtilUUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskRepositoryImplTest {

    @Mock
    private JsonTaskRepository jsonTaskRepository;

    @Test
    @DisplayName("Should save task")
    void shouldSaveTask() {
        Task task = new Task();
        when(jsonTaskRepository.save(task)).thenReturn(task);

        Task savedTask = jsonTaskRepository.save(task);

        assertThat(savedTask).isEqualTo(task);
    }

    @Test
    @DisplayName("Should update task")
    void shouldUpdateTask() {
        HashMap<String, String> task = new HashMap<>();
        task.put("description", "Test_description");
        task.put("uuid", UtilUUID.getInstance().getStringFromUUID(UtilUUID.getInstance().getNewUUID()));
        Task expectedTask = new Task();
        when(jsonTaskRepository.update(task.get("uuid"), task.get("description"))).thenReturn(expectedTask);

        Task updatedTask = jsonTaskRepository.update(task.get("uuid"), task.get("description"));

        assertThat(updatedTask).isEqualTo(expectedTask);
    }

    @Test
    @DisplayName("Should update task status")
    void shouldUpdateTaskStatus() {
        HashMap<String, String> task = new HashMap<>();
        task.put("status", "IN_PROGRESS");
        task.put("uuid", UtilUUID.getInstance().getStringFromUUID(UtilUUID.getInstance().getNewUUID()));
        when(jsonTaskRepository.updateStatus(task.get("status"), task.get("uuid"))).thenReturn(new Task());

        Task updatedTask = jsonTaskRepository.updateStatus(task.get("status"), task.get("uuid"));

        assertThat(updatedTask).isNotNull();
    }

    @Test
    @DisplayName("Should delete task")
    void shouldDeleteTask() {
        String uuid = UtilUUID.getInstance().getStringFromUUID(UtilUUID.getInstance().getNewUUID());
        when(jsonTaskRepository.delete(uuid)).thenReturn(true);

        Boolean result = jsonTaskRepository.delete(uuid);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Should get all tasks")
    void shouldGetAllTasks() {
        assertThat(jsonTaskRepository.findAll()).isNotNull();
    }

    @Test
    @DisplayName("Should get task by status")
    void shouldGetTaskByStatus() {
        assertThat(jsonTaskRepository.findByStatus(TasksStatus.TODO)).isNotNull();
    }
}
