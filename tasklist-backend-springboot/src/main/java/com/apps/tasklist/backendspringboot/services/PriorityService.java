package com.apps.tasklist.backendspringboot.services;

import com.apps.tasklist.backendspringboot.entity.Priority;
import com.apps.tasklist.backendspringboot.repositories.PriorityRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service

//all class methods must complete without error for the transaction to complete
//if an exception occurs in the method, all performed operations will be rolled back
@Transactional
public class PriorityService {

    private final PriorityRepository repository;

    public PriorityService(PriorityRepository repository) {
        this.repository = repository;
    }

    public List<Priority> findAll() {
        return repository.findAllByOrderByIdAsc();
    }

    public Priority add(Priority priority) {
        return repository.save(priority);
    }

    public Priority update(Priority priority){
        return repository.save(priority);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Priority findById(Long id){
        return repository.findById(id).get();
    }

    public List<Priority> findByTitle(String text){
        return repository.findByTitle(text);
    }

}
