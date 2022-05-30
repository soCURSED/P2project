package com.example.p2project.Category;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data @AllArgsConstructor
public class Category {

    @NotEmpty(message = "id Most not be empty")
    @Size(min = 3, max = 3)
    private String id;


    @NotEmpty(message = "name Most not be empty")
    @Size(min = 3, max = 3)
    private String name;

}
