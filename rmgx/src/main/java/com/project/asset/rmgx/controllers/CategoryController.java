package com.project.asset.rmgx.controllers;

import com.project.asset.rmgx.payloads.ApiResponse;
import com.project.asset.rmgx.payloads.CategoryDto;
import com.project.asset.rmgx.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestControllerAdvice
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryServices categoryServices;
    //create
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto createdCategory = this.categoryServices.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createdCategory, HttpStatus.CREATED);
    }
    //update
    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable Integer catId){
        CategoryDto updatedCategory = this.categoryServices.updateCategory(categoryDto, catId);
        return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
    }

    //delete
@DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){
        this.categoryServices.deleteCategory(catId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully",true),HttpStatus.OK);
}
    //get
    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId){
        CategoryDto categoryDto = this.categoryServices.getCategory(catId);
        return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
    }

    //getAll
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategories(){
        List<CategoryDto> categories = this.categoryServices.getCategories();

        return ResponseEntity.ok(categories);
    }
}
