package boris.enterprice.domain.model;

import boris.enterprice.domain.model.enums.TasksStatus;
import boris.enterprice.utils.UtilText;
import boris.enterprice.utils.UtilUUID;

import java.util.Date;
import java.util.UUID;

import static boris.enterprice.utils.Constants.*;

/**
 * Represents a task with a unique identifier, description, status, and timestamps.
 */
public class Task {
    private UUID id;
    private String description;
    private TasksStatus status;
    private Date createdAt;
    private Date updatedAt;

    /**
     * Default constructor for Task.
     */
    public Task(){
        setId(DEFAULT_UUID);
        setDescription(EMPTY_STRING);
        setStatus(TasksStatus.TODO);
        setCreatedAt(DEFAULT_DATE);
        setUpdatedAt(DEFAULT_DATE);
    }

    /**
     * Constructor for Task.
     *
     * @param id the unique identifier of the task
     * @param description the description of the task
     * @param status the status of the task
     * @param createdAt the creation timestamp of the task
     * @param updatedAt the last update timestamp of the task
     */
    public Task(UUID id, String description, TasksStatus status, Date createdAt, Date updatedAt) {
        setId(id);
        setDescription(description);
        setStatus(status);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
    }

    /**
     * Gets the unique identifier of the task.
     *
     * @return the unique identifier
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the task.
     *
     * @param id the unique identifier
     */
    private void setId(final UUID id) {
        this.id = UtilUUID.getInstance().getDefaulUUID(id);
    }

    /**
     * Gets the description of the task.
     *
     * @return the description of the task
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the task.
     *
     * @param description the description of the task
     */
    public void setDescription(final String description) {
        this.description = UtilText.getInstance().getDefaultText(description);
    }

    /**
     * Gets the status of the task.
     *
     * @return the status of the task
     */
    public TasksStatus getStatus() {
        return status;
    }

    /**
     * Sets the status of the task.
     *
     * @param status the status of the task
     */
    public void setStatus(final TasksStatus status) {
        this.status = status;
    }

    /**
     * Gets the creation timestamp of the task.
     *
     * @return the creation timestamp
     */
    public Date getCreatedAt() {
        return createdAt;
    }


    /**
     * Sets the creation timestamp of the task.
     *
     * @param createdAt the creation timestamp
     */
    private void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the last update timestamp of the task.
     *
     * @return the last update timestamp
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the last update timestamp of the task.
     *
     * @param updatedAt the last update timestamp
     */
    public void setUpdatedAt(final Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
