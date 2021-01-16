package com.sevensummits.jwt.demo.task;

public interface TaskService {

    Task create(TaskCreateDto task);

    Iterable<Task> listTasks();
}
