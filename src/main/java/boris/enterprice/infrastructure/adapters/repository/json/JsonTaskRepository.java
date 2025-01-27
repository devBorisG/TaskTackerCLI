package boris.enterprice.infrastructure.adapters.repository.json;

import boris.enterprice.domain.model.Task;
import boris.enterprice.domain.model.enums.TasksStatus;
import boris.enterprice.domain.repository.TaskRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonTaskRepository implements TaskRepository {
    private final String filePath;
    private final ObjectMapper objectMapper;

    public JsonTaskRepository(String filePath) {
        this.filePath = filePath;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Task save(Task task) {
        List<Task> tasks = findAll();
        tasks.add(task);
        try{
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), tasks);
        }catch (IOException e){
            e.printStackTrace();
        }
        return task;
    }

    @Override
    public List<Task> findByStatus(TasksStatus status) {
        return List.of();
    }

    @Override
    public Task update(String uuid) {
        return null;
    }

    @Override
    public boolean delete(String uuid) {
        return false;
    }

    @Override
    public List<Task> findAll() {
        File file = new File(filePath);
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }

        try {
            return objectMapper.readValue(file, new TypeReference<>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
