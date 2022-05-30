package com.example.p2project.Category;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {
    private ArrayList<Category> categoryList = new ArrayList<>();

    public ArrayList<Category> getCategories(){
        return categoryList;
    }

    public void addCategory(Category category){
        categoryList.add(category);
    }

    public Boolean updateCategory(Integer index, Category category){
        if(index > categoryList.size()-1){
            return false;
        }
        categoryList.set(index, category);
        return true;
    }

    public Boolean deleteCategory(String categoryId){
        for(Category category: categoryList){
            if (categoryId.equals(category.getId())){
                categoryList.remove(category);
                return true;
            }
        }
        return false;
    }

}
