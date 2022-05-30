package com.example.p2project.MerchentStock;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data @AllArgsConstructor
public class MerchantStock {
    @NotEmpty(message = "id Most not be empty")
    @Size(min = 3, max = 3)
    private String id;

    @NotEmpty(message = "product Most not be empty")
    @Size(min = 3, max = 3)
    private String productId;

    @NotEmpty(message = "merchentid Most not be empty")
    @Size(min = 3, max = 3)
    private String merchantId;

    @NotNull(message = "stock Most not be null")
    @Min(10)
    private Integer stock;

}
