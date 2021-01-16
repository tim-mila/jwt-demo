package com.sevensummits.jwt.demo.task;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Default JPA backed {@link TaskService}
 */
@Service
class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Create a new {@link Task}
     *
     * @param task {@link TaskCreateDto}
     * @return Created {@link Task}
     */
    @Override
    @Transactional
    public Task create(final TaskCreateDto task) {
        return taskRepository.save(task.toTask());
    }

    /**
     * Find tasks associated with currently authenticated principal
     *
     * @return Iterable of {@link Task}
     */
    @Override
    @Transactional
    public Iterable<Task> listTasks() {
        return taskRepository.findByOwner();
    }
}
