package com.ramirogonzalez.simpleTodoList.service;

import com.ramirogonzalez.simpleTodoList.model.Task;

import java.util.List;

public interface ITaskService {

    List<Task> getOrderTasks();
    List<Task> getTasks();

    Task getTask(Long id);

    long saveTask(Task task);

    void deleteTask(Long id);

    Task updateTask(Long id, Task task);

    void toggleComplete(Long id);


}
