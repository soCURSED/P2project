package com.example.p2project.Merchent;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data @AllArgsConstructor
public class Merchant {

    @NotEmpty(message = "id Most not be empty")
    @Size(min = 3, max = 3)
    private String id;

    @NotEmpty(message = "name Most not be empty")
    @Size(min = 3, max = 3)
    private String name;

}
