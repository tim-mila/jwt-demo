package com.sevensummits.jwt.demo.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

/**
 * {@link Task} {@link JpaRepository}
 */
interface TaskRepository extends JpaRepository<Task, UUID> {

    /**
     * Query {@link Task} associated with authenticated principal
     *
     * @return Iterable of {@link Task}
     */
    @Query("from Task t where t.owner.username = ?#{principal}")
    Iterable<Task> findByOwner();
}
