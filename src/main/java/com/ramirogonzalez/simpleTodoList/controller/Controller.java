package com.ramirogonzalez.simpleTodoList.controller;

import com.ramirogonzalez.simpleTodoList.model.ResponseMessage;
import com.ramirogonzalez.simpleTodoList.model.Task;
import com.ramirogonzalez.simpleTodoList.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//enable cors to work with angular
@CrossOrigin
@RestController
public class Controller {

    @Autowired
    TaskService taskService;

    @GetMapping("/orderTasks")
    public List<Task> getOrderTasks(){
        return taskService.getOrderTasks();
    }

    @GetMapping("/tasks")
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @GetMapping("/task/{id}")
    public Task getTask(@PathVariable Long id){
        return taskService.getTask(id);
    }

    @PostMapping("/task")
    public long saveTask(@RequestBody Task task){
        return taskService.saveTask(task);
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<ResponseMessage> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.ok(new ResponseMessage("Task with id: " + id + " deleted succesfully"));
    }

    @PutMapping("/task/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task){
        return taskService.updateTask(id, task);
    }

    @PutMapping("/task/complete/{id}")
    public void toggleComplete(@PathVariable Long id){
        taskService.toggleComplete(id);
    }



}
