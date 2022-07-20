package com.project.asset.rmgx.services;

import com.project.asset.rmgx.payloads.CategoryDto;

import java.util.List;

public interface CategoryServices {
    //create
    public CategoryDto createCategory(CategoryDto categoryDto);

    //update
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    //delete
    void deleteCategory(Integer categoryId);
    //get
    CategoryDto getCategory(Integer categoryId);

    //get All
    List<CategoryDto> getCategories();

}
