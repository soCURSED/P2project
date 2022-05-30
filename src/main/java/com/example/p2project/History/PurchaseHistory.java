package com.example.p2project.History;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data @AllArgsConstructor
public class PurchaseHistory {
    @NotEmpty(message = "id Most not be empty")
    @Size(min = 3, max = 3)
    private String id;

    @NotEmpty(message = "userid Most not be empty")
    @Size(min = 3, max = 3)
    private String userId;

    @NotEmpty(message = "productid Most not be empty")
    @Size(min = 3, max = 3)
    private String productId;

    @NotNull(message = "price Most not be null")
    @Positive
    private Double price;
}
