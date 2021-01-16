package com.sevensummits.jwt.demo.task;

import com.fasterxml.jackson.annotation.JsonView;
import com.sevensummits.jwt.demo.global.json.Views;
import org.springframework.web.bind.annotation.*;

/**
 * Public {@link Task} API
 */
@RestController
@RequestMapping(TaskController.PATH)
@JsonView(Views.Public.class)
class TaskController {

    static final String PATH = "/task";

    private final TaskService taskService;

    public TaskController(final TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Create a {@link Task}
     *
     * @param task {@link TaskCreateDto}
     * @return Created task
     */
    @PostMapping
    @JsonView(Views.Public.class)
    Task create(@RequestBody TaskCreateDto task) {
        return taskService.create(task);
    }

    /**
     * List tasks
     *
     * @return Iterable of {@link Task}
     */
    @GetMapping
    @JsonView(Views.Public.class)
    Iterable<Task> list() {
        return taskService.listTasks();
    }
}
