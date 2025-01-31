package boris.enterprice.application.task;

import boris.enterprice.domain.model.Task;
import boris.enterprice.domain.model.enums.TasksStatus;
import boris.enterprice.domain.repository.TaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ListByStatusTaskUseCaseTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private ListByStatusTaskUseCase listByStatusTaskUseCase;

    @Test
    @DisplayName("Should list tasks by TODO status")
    void shouldListTaskByTodoStatus() {
        when(taskRepository.findByStatus(TasksStatus.TODO)).thenReturn(List.of());

        List<Task> result = listByStatusTaskUseCase.execute(TasksStatus.TODO);

        assertThat(result).isEqualTo(List.of());
    }

    @Test
    @DisplayName("Should list tasks by in progress status")
    void shouldListTaskByInProgressStatus() {
        when(taskRepository.findByStatus(TasksStatus.IN_PROGRESS)).thenReturn(List.of());

        List<Task> result = listByStatusTaskUseCase.execute(TasksStatus.IN_PROGRESS);

        assertThat(result).isEqualTo(List.of());
    }

    @Test
    @DisplayName("Should list tasks by done status")
    void shouldListTaskByDoneStatus() {
        when(taskRepository.findByStatus(TasksStatus.DONE)).thenReturn(List.of());

        List<Task> result = listByStatusTaskUseCase.execute(TasksStatus.DONE);

        assertThat(result).isEqualTo(List.of());
    }
}
