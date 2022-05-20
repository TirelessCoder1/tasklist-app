package com.apps.tasklist.backendspringboot.controllers;

import com.apps.tasklist.backendspringboot.entity.Task;
import com.apps.tasklist.backendspringboot.repositories.TaskRepository;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/task") // basic address
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository, ConfigurableEnvironment environment) {
        this.taskRepository = taskRepository;
    }

    //return all tasks/objects
    @GetMapping("/all")
    public ResponseEntity<List<Task>> findAll() {

        return  ResponseEntity.ok(taskRepository.findAll());
    }

    //add new task
    @PostMapping("/add")
    public ResponseEntity<Task> add(@RequestBody Task task) {


        if (task.getId() != null && task.getId() != 0) {
            return new ResponseEntity("redundant param: id MUST be null", HttpStatus.NOT_ACCEPTABLE);
        }

        if (task.getTitle() == null || task.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(taskRepository.save(task));
    }

    //update task
    @PutMapping("/update")
    public ResponseEntity<Task> update(@RequestBody Task task) {

        if (task.getId() == null || task.getId() == 0) {
            return new ResponseEntity("missed param: id", HttpStatus.NOT_ACCEPTABLE);
        }

        if (task.getTitle() == null || task.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }

        taskRepository.save(task);

        return new ResponseEntity(HttpStatus.OK);
    }

    // delete by id
    // id parameter passes in URL itself, isntead of request`s body
        @DeleteMapping("/delete/{id}")
        public ResponseEntity delete(@PathVariable Long id) {

            try {
                taskRepository.deleteById(id);
            }catch (EmptyResultDataAccessException e) {
                e.printStackTrace();
                return new ResponseEntity("id="+id+" not found", HttpStatus.NOT_ACCEPTABLE);
            }

            return new ResponseEntity(HttpStatus.OK);
        }

    // get task by id from the path
    @GetMapping("/id/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {

        Task task = null;

        try{
            task = taskRepository.findById(id).get();
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return new ResponseEntity("id="+id+" not found", HttpStatus.NOT_ACCEPTABLE);
        }

        return  ResponseEntity.ok(task);
    }

}
