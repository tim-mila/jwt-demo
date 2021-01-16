package com.sevensummits.jwt.demo.task;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

/**
 * Sanitized request body class for creating a new task
 */
public class TaskCreateDto {

    private final String description;

    @JsonCreator
    public TaskCreateDto(@NonNull @JsonProperty final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Convert create task request to transient task entity
     *
     * @return Task
     */
    public Task toTask() {
        final Task task = new Task();
        task.setDescription(description);
        return task;
    }
}
