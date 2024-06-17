package com.ramirogonzalez.simpleTodoList.service;

import com.ramirogonzalez.simpleTodoList.model.Task;
import com.ramirogonzalez.simpleTodoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskService implements ITaskService{

    @Autowired
    TaskRepository taskRepository;


    @Override
    public List<Task> getOrderTasks() {
        return taskRepository.findAllByOrderByIdAsc();
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTask(Long id) {
        return taskRepository.findById(id).orElseThrow(()-> new NoSuchElementException("There is not a task with id: " + id));
    }

    @Override
    public long saveTask(Task task) {
        return taskRepository.save(task).getId();
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task updateTask(Long id, Task task) {

        Task taskExist = this.getTask(id);

        taskExist.setTitle(task.getTitle());
        taskExist.setDescription(task.getDescription());
        taskExist.setCompleted(task.isCompleted());

        taskRepository.save(taskExist);
        return taskExist;
    }

    @Override
    public void toggleComplete(Long id) {

        Task taskExist = this.getTask(id);
        taskExist.setCompleted(!taskExist.isCompleted());
        taskRepository.save(taskExist);

    }


}
