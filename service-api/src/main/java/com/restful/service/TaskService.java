package com.restful.service;

import com.restful.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<Task> getAllTasks();

    Task saveOrUpdateTask(Task task);

    Optional<Task> getTaskByName(String taskName);

    Optional<Task> getTaskById(Long taskId);

    void deleteTaskById(Long taskId);
}
