package com.apps.tasklist.backendspringboot.controllers;

import com.apps.tasklist.backendspringboot.entity.Stat;
import com.apps.tasklist.backendspringboot.services.StatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StatController {

    private final StatService statService;

    public StatController(StatService statService) {
        this.statService = statService;
    }

    private final Long defaultId = 1l;

    @GetMapping("/stat")
    public ResponseEntity<Stat> findById() {

        return  ResponseEntity.ok(statService.findById(defaultId));
    }
}
