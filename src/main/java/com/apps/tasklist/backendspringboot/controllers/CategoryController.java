package com.apps.tasklist.backendspringboot.controllers;

import com.apps.tasklist.backendspringboot.entity.Category;
import com.apps.tasklist.backendspringboot.entity.Priority;
import com.apps.tasklist.backendspringboot.repositories.CategoryRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping ("/category")
public class CategoryController {

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<Category> add(@RequestBody Category category) {

        //Check for required parameters
        if (category.getId() != null && category.getId() != 0) {
            // 'id' is created automatically in the database (autoincrement), so it does not need to be passed, otherwise there may be a conflict with the uniqueness of the value
            return new ResponseEntity("redundant param: id MUST be null", HttpStatus.NOT_ACCEPTABLE);
        }

        // check if 'title' is empty
        if (category.getTitle() == null || category.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(categoryRepository.save(category));
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Category category) {
        //Check for required parameters
        if (category.getId() == null && category.getId() == 0) {
            return new ResponseEntity("missed param: id", HttpStatus.NOT_ACCEPTABLE);
        }

        // check if 'title' is empty
        if (category.getTitle() == null || category.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(categoryRepository.save(category));
    }

    //get element by id from the path
    @GetMapping("/id/{id}")
    public ResponseEntity<Category> findbyID(@PathVariable Long id) {

        Category category = null;
        try {
            category = categoryRepository.findById(id).get();
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return new ResponseEntity("id="+id+" not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(category);
    }

    //sort categories by title
    @GetMapping("/all")
    public List<Category> sortElements() {

        return categoryRepository.findAllByOrderByTitleAsc();
    }

    //delete element by id from the path
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        try {
            categoryRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity("id="+id+" not found", HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

}
