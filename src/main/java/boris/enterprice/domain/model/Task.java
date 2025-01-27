package boris.enterprice.domain.model;

import boris.enterprice.domain.model.enums.TasksStatus;
import boris.enterprice.utils.UtilText;
import boris.enterprice.utils.UtilUUID;

import java.util.Date;
import java.util.UUID;

import static boris.enterprice.utils.Constants.*;

public class Task {
    private UUID id;
    private String description;
    private TasksStatus status;
    private Date createdAt;
    private Date updatedAt;

    public Task(){
        setId(DEFAULT_UUID);
        setDescription(EMPTY_STRING);
        setStatus(TasksStatus.TODO);
        setCreatedAt(DEFAULT_DATE);
        setUpdatedAt(DEFAULT_DATE);
    }

    public Task(UUID id, String description, TasksStatus status, Date createdAt, Date updatedAt) {
        setId(id);
        setDescription(description);
        setStatus(status);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
    }

    public UUID getId() {
        return id;
    }

    private void setId(final UUID id) {
        this.id = UtilUUID.getInstance().getDefaulUUID(id);
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(final String description) {
        this.description = UtilText.getInstance().getDefaultText(description);
    }

    public TasksStatus getStatus() {
        return status;
    }

    private void setStatus(final TasksStatus status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    private void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    private void setUpdatedAt(final Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
