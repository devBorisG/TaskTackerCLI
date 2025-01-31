package boris.enterprice.application.task;

import boris.enterprice.domain.model.Task;
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
class ListTaskUseCaseTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private ListTaskUseCase listTaskUseCase;

    @Test
    @DisplayName("Should list all tasks")
    void shouldListAllTasks() {
        when(taskRepository.findAll()).thenReturn(List.of());

        List<Task> result = listTaskUseCase.execute();

        assertThat(result).isEqualTo(List.of());
    }
}
