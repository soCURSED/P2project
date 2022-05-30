package com.example.p2project.Cart;

import com.example.p2project.Product.Product;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
public class Cart {
    @NotEmpty(message = "id Most not be empty")
    @Size(min = 3, max = 3)
    private String id;

    @NotEmpty(message = "userId Most not be empty")
    @Size(min = 3, max = 3)
    private String userId;

    private ArrayList<Product> products;

    public Cart(String id, String userId) {
        this.id = id;
        this.userId = userId;
        this.products = new ArrayList<>();
    }

    public boolean addProduct(Product product){
        products.add(product);
        return true;
    }
}
