package com.apps.tasklist.backendspringboot.controllers;

import com.apps.tasklist.backendspringboot.entity.Priority;
import com.apps.tasklist.backendspringboot.search.PrioritySearchValues;
import com.apps.tasklist.backendspringboot.services.PriorityService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping ("/priority")
public class PriorityController {

    private final PriorityService priorityService;

    public PriorityController(PriorityService priorityService) {
        this.priorityService = priorityService;
    }


    //get and sort priorities by id
    @GetMapping("/all")
    public List<Priority> sortElements() {

        return priorityService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Priority> add(@RequestBody Priority priority) {

        //Check for required parameters
        if (priority.getId() != null && priority.getId() != 0) {
            // 'id' is created automatically in the database (autoincrement), so it does not need to be passed, otherwise there may be a conflict with the uniqueness of the value
            return new ResponseEntity("redundant param: id MUST be null", HttpStatus.NOT_ACCEPTABLE);
        }

        // check if 'title' is empty
        if (priority.getTitle() == null || priority.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }

        //check if 'color' is empty
        if (priority.getColor() == null || priority.getColor().trim().length() == 0) {
            return new ResponseEntity("missed param: color", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(priorityService.add(priority));
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Priority priority) {
        //Check for required parameters
        if (priority.getId() == null && priority.getId() == 0) {
            return new ResponseEntity("missed param: id", HttpStatus.NOT_ACCEPTABLE);
        }

        // check if 'title' is empty
        if (priority.getTitle() == null || priority.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }
        //check if 'color' is empty
        if (priority.getColor() == null || priority.getColor().trim().length() == 0) {
            return new ResponseEntity("missed param: color", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(priorityService.update(priority));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Priority> findbyID(@PathVariable Long id) {

        Priority priority = null;
        try{
            priority = priorityService.findById(id);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return new ResponseEntity("id="+id+" not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(priority);
    }

    //delete element by id from the path
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        try {
            priorityService.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity("id="+id+" not found", HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity <List<Priority>> search(@RequestBody PrioritySearchValues prioritySearchValues) {

        return ResponseEntity.ok(priorityService.findByTitle(prioritySearchValues.getText()));
    }
}
