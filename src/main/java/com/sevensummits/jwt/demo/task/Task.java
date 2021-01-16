package com.sevensummits.jwt.demo.task;

import com.fasterxml.jackson.annotation.JsonView;
import com.sevensummits.jwt.demo.global.json.Views;
import com.sevensummits.jwt.demo.user.ApplicationUser;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Task entity class
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    @JsonView(Views.Public.class)
    private UUID id;

    @CreatedBy
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false, updatable = false)
    private ApplicationUser owner;

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    @JsonView(Views.Public.class)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "last_modified_date", nullable = false, updatable = false)
    @JsonView(Views.Public.class)
    private LocalDateTime lastModifiedDate;

    @JsonView(Views.Public.class)
    private String description;

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public ApplicationUser getOwner() {
        return owner;
    }

    public void setOwner(final ApplicationUser owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(final LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", description='" + description + '\'' + '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Task task = (Task) o;
        return Objects.equals(id, task.id) &&
                Objects.equals(owner, task.owner) &&
                Objects.equals(createdDate, task.createdDate) &&
                Objects.equals(lastModifiedDate, task.lastModifiedDate) &&
                Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, owner, createdDate, lastModifiedDate, description);
    }
}
