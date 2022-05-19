package com.apps.tasklist.backendspringboot.repositories;

import com.apps.tasklist.backendspringboot.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    //sort elements by title
    List<Category> findAllByOrderByTitleAsc();
}
