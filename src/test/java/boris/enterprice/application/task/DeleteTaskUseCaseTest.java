package boris.enterprice.application.task;

import boris.enterprice.domain.repository.TaskRepository;
import boris.enterprice.utils.UtilUUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeleteTaskUseCaseTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private DeleteTaskUseCase deleteTaskUseCase;

    @Test
    @DisplayName("Should delete task with the uuid")
    void shouldDeleteTask() {
        String uuid = UtilUUID.getInstance().getStringFromUUID(UtilUUID.getInstance().getNewUUID());
        when(taskRepository.delete(uuid)).thenReturn(true);

        Boolean result = deleteTaskUseCase.execute(uuid);

        assertThat(result).isTrue();
    }
}
