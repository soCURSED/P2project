package com.example.p2project.Comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data @AllArgsConstructor
public class Comment {
    @NotEmpty(message = "id Most not be empty")
    @Size(min = 3, max = 3)
    private String id;

    @NotEmpty(message = "userid Most not be empty")
    @Size(min = 5, max = 5)
    private String userId;

    @NotNull(message = "rate Most not be null")
    @Range(min = 1, max = 5)
    private Integer rate;

    @NotEmpty(message = "message Most not be empty")
    @Size(min = 6, max = 50)
    private String message;


}
