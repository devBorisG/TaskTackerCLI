package boris.enterprice.application.task;

import boris.enterprice.domain.model.Task;
import boris.enterprice.domain.repository.TaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddTaskUseCaseTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private AddTaskUseCase addTaskUseCase;

    @Test
    @DisplayName("Should add task and return it")
    void shouldAddTask() {
        Task task = new Task();
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task result = addTaskUseCase.execute(task.getDescription());

        assertThat(result).isEqualTo(task);
    }
}
