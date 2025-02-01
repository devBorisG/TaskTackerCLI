package boris.enterprice.domain.repository;

import boris.enterprice.domain.model.Task;
import boris.enterprice.domain.model.enums.TasksStatus;

import java.util.List;

/**
 * Interface for the repository of tasks.
 */
public interface TaskRepository {

    /**
     * Saves a task.
     *
     * @param task the task to save
     * @return the saved task
     */
    Task save(Task task);

    /**
     * Finds a task by status.
     *
     *  @param status the status to search for
     *  @return the list of tasks with the given status
     */
    List<Task> findByStatus(TasksStatus status);

    /**
     * Updates the description for a task.
     *
     * @param uuid the UUID of the task to update
     * @param description the new description
     * @return the updated task
     */
    Task update(String uuid, String description);

    /**
     * Updates the status of a task.
     *
     * @param status the new status
     * @param uuid the UUID of the task to update
     * @return the updated task
     */
    Task updateStatus(String status, String uuid);

    /**
     * Deletes a task.
     *
     * @param uuid the UUID of the task to delete
     * @return true if the task was deleted, false otherwise
     */
    boolean delete(String uuid);

    /**
     * Finds all tasks.
     *
     * @return the list of all tasks
     */
    List<Task> findAll();
}
