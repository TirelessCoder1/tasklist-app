package com.apps.tasklist.backendspringboot.controllers;

import com.apps.tasklist.backendspringboot.entity.Task;
import com.apps.tasklist.backendspringboot.search.TaskSearchValues;
import com.apps.tasklist.backendspringboot.services.TaskService;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/task") // basic address
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService, ConfigurableEnvironment environment) {
        this.taskService = taskService;
    }

    //return all tasks/objects
    @GetMapping("/all")
    public ResponseEntity<List<Task>> findAll() {

        return  ResponseEntity.ok(taskService.findAll());
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

        return ResponseEntity.ok(taskService.add(task));
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

        taskService.update(task);

        return new ResponseEntity(HttpStatus.OK);
    }

    // delete by id
    // id parameter passes in URL itself, isntead of request`s body
        @DeleteMapping("/{id}")
        public ResponseEntity delete(@PathVariable Long id) {

            try {
                taskService.deleteById(id);
            }catch (EmptyResultDataAccessException e) {
                e.printStackTrace();
                return new ResponseEntity("id="+id+" not found", HttpStatus.NOT_ACCEPTABLE);
            }

            return new ResponseEntity(HttpStatus.OK);
        }

    // get task by id from the path
    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {

        Task task = null;

        try{
            task = taskService.findById(id);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return new ResponseEntity("id="+id+" not found", HttpStatus.NOT_ACCEPTABLE);
        }

        return  ResponseEntity.ok(task);
    }

    //Search by any parameter
    @PostMapping("/search")
    public ResponseEntity<Page<Task>> search(@RequestBody TaskSearchValues taskSearchValues) {

        String text = taskSearchValues.getTitle() != null ? taskSearchValues.getTitle() : null;
        Integer completed = taskSearchValues.getCompleted() != null ?  taskSearchValues.getCompleted() : null;
        Long priorityId = taskSearchValues.getPriorityId() != null ? taskSearchValues.getPriorityId() : null;
        Long categoryId = taskSearchValues.getCategoryId() != null ? taskSearchValues.getCategoryId() : null;

        String sortColumn = taskSearchValues.getSortColumn() != null ? taskSearchValues.getSortColumn() : null;
        String sortDirection = taskSearchValues.getSortDirection() != null ? taskSearchValues.getSortDirection() : null;

        Integer pageNumber = taskSearchValues.getPageNumber() != null ? taskSearchValues.getPageNumber() : null;
        Integer pageSize = taskSearchValues.getPageSize() != null ? taskSearchValues.getPageSize() : null;

        //sort in ascending order by default
        Sort.Direction direction = sortDirection == null || sortDirection.trim().equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;

        Sort sort = Sort.by(direction, sortColumn);

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);

        Page page = taskService.findByParams(text, completed, priorityId, categoryId, pageRequest);

        return ResponseEntity.ok(page);

    }

}
