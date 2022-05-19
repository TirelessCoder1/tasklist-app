package com.apps.tasklist.backendspringboot.repositories;


import com.apps.tasklist.backendspringboot.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {

    //sort elements by id
    List<Priority> findAllByOrderByIdAsc();
}
