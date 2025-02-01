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


/**
 * Implementation of TaskRepository that uses a JSON file for storage.
 */
public class JsonTaskRepository implements TaskRepository {
    private final String filePath;
    private final ObjectMapper objectMapper;

    /**
     * Constructor for JsonTaskRepository.
     *
     * @param filePath the path to the JSON file
     */
    public JsonTaskRepository(String filePath) {
        this.filePath = filePath;
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Saves a task to the JSON file.
     *
     * @param task the task to save
     * @return the saved task
     */
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

    /**
     * Updates the status of a task in the JSON file.
     *
     * @param status the new status
     * @param uuid the UUID of the task to update
     * @return the updated task, or null if not found
     */
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

    /**
     * Finds tasks by their status.
     *
     * @param status the status to search for
     * @return a list of tasks with the given status
     */
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

    /**
     * Updates the description of a task in the JSON file.
     *
     * @param uuid the UUID of the task to update
     * @param description the new description
     * @return the updated task, or null if not found
     */
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

    /**
     * Deletes a task from the JSON file.
     *
     * @param uuid the UUID of the task to delete
     * @return true if the task was deleted, false if not found
     */
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

    /**
     * Finds all tasks in the JSON file.
     *
     * @return a list of all tasks
     */
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
