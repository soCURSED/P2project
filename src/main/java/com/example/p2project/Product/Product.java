package com.example.p2project.Product;

import com.example.p2project.Comment.Comment;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
public class Product {
    @NotEmpty(message = "id Most not be empty")
    @Size(min = 3, max = 5)
    private String id;
    @NotEmpty(message = "name Most not be empty")
    @Size(min = 3, max = 25)
    private String name;

    @NotNull(message = "price most not be null")
    @Positive(message = "Only positive price!")
    private Double price;
    @NotEmpty(message = "categoryId Most not be empty")
    @Size(min = 3, max = 5)
    private String categoryId;

    private ArrayList<Comment> comments;

    public Product(String id, String name, Double price, String categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
        this.comments = new ArrayList<>();
    }

    public boolean addComment(Comment comment){
        comments.add(comment);
        return true;
    }
}
