package com.apps.tasklist.backendspringboot.controllers;

import com.apps.tasklist.backendspringboot.entity.Priority;
import com.apps.tasklist.backendspringboot.repositories.PriorityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/priority")
public class PriorityController {

    private PriorityRepository priorityRepository;

    public PriorityController(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    //Testing Get queries
    @GetMapping("test")
    public List<Priority> test() {

        List<Priority> list = priorityRepository.findAll();
        return list;
    }

    @PostMapping("/add")
    public Priority add(@RequestBody Priority priority) {
        return priorityRepository.save(priority);
    }
}
