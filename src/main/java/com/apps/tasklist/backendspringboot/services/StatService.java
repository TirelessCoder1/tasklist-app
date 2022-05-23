package com.apps.tasklist.backendspringboot.services;

import com.apps.tasklist.backendspringboot.entity.Stat;
import com.apps.tasklist.backendspringboot.repositories.StatRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class StatService {

    private final StatRepository repository;

    public StatService(StatRepository repository) {
        this.repository = repository;
    }

    public Stat findById(Long id){
        return repository.findById(id).get();
    }
}

