package boris.enterprice.infrastructure.adapters.repository.json;

import boris.enterprice.domain.model.Task;
import boris.enterprice.domain.model.enums.TasksStatus;
import boris.enterprice.domain.repository.TaskRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
    public Task updateStatus(String status, String uuid) {
        List<Task> tasks = findAll();
        for (Task task : tasks) {
            if (task.getId().toString().equals(uuid)) {
                task.setStatus(TasksStatus.valueOf(status));
                task.setUpdatedAt(new Date());
                try {
                    objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), tasks);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return task;
            }
        }
        return null;
    }

    @Override
    public List<Task> findByStatus(TasksStatus status) {
        List<Task> tasks = findAll();
        List<Task> tasksByStatus = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getStatus().equals(status)) {
                tasksByStatus.add(task);
            }
        }
        return tasksByStatus;
    }

    @Override
    public Task update(String uuid, String description) {
        List<Task> tasks = findAll();
        for (Task task : tasks) {
            if (task.getId().toString().equals(uuid)) {
                task.setDescription(description);
                task.setUpdatedAt(new Date());
                try {
                    objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), tasks);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return task;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String uuid) {
        List<Task> tasks = findAll();
        for (Task task : tasks) {
            if (task.getId().toString().equals(uuid)) {
                tasks.remove(task);
                try {
                    objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), tasks);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            }
        }
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
