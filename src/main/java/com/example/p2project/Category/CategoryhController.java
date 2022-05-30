package com.example.p2project.Category;

import com.example.p2project.Logs.Logs;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController @RequiredArgsConstructor
@RequestMapping("api/v1/category")
public class CategoryhController {
    private final CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity getCategory(){
        return ResponseEntity.status(200).body(categoryService.getCategories());
    }

    //add
    @PostMapping("/")
    public ResponseEntity addCategory(@RequestBody @Valid Category category, Errors error){
        if(error.hasErrors()){
            return ResponseEntity.status(400).body(new Logs("Error incorrect Data!", 400, error.getFieldError().getDefaultMessage()));

        }


        categoryService.addCategory(category);
        return ResponseEntity.status(201).body(new Logs("Category Successfully Added!", 201));
    }

    //update
    @PutMapping("/{index}")
    public ResponseEntity updateCategory(@RequestBody @Valid Category category, @PathVariable Integer index, Errors error){
        if(error.hasErrors()){
            return ResponseEntity.status(400).body(new Logs("Error incorrect Data!", 400, error.getFieldError().getDefaultMessage()));
        } else if (categoryService.updateCategory(index, category)) {
            return ResponseEntity.status(201).body(new Logs("Category Successfully deleted!", 201));
        }
        return ResponseEntity.status(400).body(new Logs("Error incorrect Index!", 400));
    }

    //delete
    @DeleteMapping("/")
    public ResponseEntity deleteCategory(@RequestParam String categoryId){
        if(categoryService.deleteCategory(categoryId)){
            return ResponseEntity.status(201).body(new Logs("Category Successfully deleted!", 201));
        }
        return ResponseEntity.status(400).body(new Logs("Error incorrect Category Id!", 400));
    }


}
