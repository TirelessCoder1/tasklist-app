package com.apps.tasklist.backendspringboot.controllers;

import com.apps.tasklist.backendspringboot.entity.Task;
import com.apps.tasklist.backendspringboot.repositories.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/task")
public class TaskController {

    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    //Testing Get queries
    @GetMapping("test")
    public List<Task> test() {
        
        List<Task> list = taskRepository.findAll();
        return list;
    }

    @PostMapping("/add")
    public Task add(@RequestBody Task task) {
        return taskRepository.save(task);
    }
}
