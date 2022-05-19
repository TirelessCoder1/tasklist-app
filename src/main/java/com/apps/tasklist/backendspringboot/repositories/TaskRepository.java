package com.apps.tasklist.backendspringboot.repositories;

import com.apps.tasklist.backendspringboot.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
