package com.apps.tasklist.backendspringboot.controllers;

import com.apps.tasklist.backendspringboot.entity.Stat;
import com.apps.tasklist.backendspringboot.repositories.StatRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/stat")
public class StatController {

    private StatRepository statRepository;

    public StatController(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    //Testing Get queries
    @GetMapping("test")
    public List<Stat> test() {

        List<Stat> list = statRepository.findAll();
        return list;
    }

    @PostMapping("/add")
    public Stat add(@RequestBody Stat stat) {
        return statRepository.save(stat);
    }
}
