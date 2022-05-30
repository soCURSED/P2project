package com.example.p2project.Product;
import com.example.p2project.Logs.Logs;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController @RequiredArgsConstructor
@RequestMapping("api/v1/product")
public class ProductController {
    private final ProductService productService;

    //get
    @GetMapping("/")
    public ResponseEntity getProducts()
    {
        return ResponseEntity.status(200).body(productService.getProducts());
    }


    //add
    @PostMapping("/")
    public ResponseEntity addProduct(@RequestBody @Valid Product product, Errors error)
    {
        if(error.hasErrors())
        {
            return ResponseEntity.status(400).body(new Logs("Error incorrect Data", 400, error.getFieldError().getDefaultMessage()));
        }
        productService.addProduct(product);
        return ResponseEntity.status(201).body(new Logs("Product Successfully Added!", 201));
    }


    //update
    @PutMapping("/{index}")
    public ResponseEntity updateProduct(@RequestBody @Valid Product product, @PathVariable Integer index, Errors error){
        if(error.hasErrors())
        {
            return ResponseEntity.status(400).body(new Logs("Error incorrect Data", 400, error.getFieldError().getDefaultMessage()));
        }
        else if (productService.updateProduct(index, product))
        {
            return ResponseEntity.status(201).body(new Logs("Product Successfully Updated!", 201));
        }

        return ResponseEntity.status(400).body(new Logs("Error incorrect Index", 400));
    }

    //delete
    @DeleteMapping("/")
    public ResponseEntity deleteProduct(@RequestParam String productId)
    {
        if(productService.deleteProduct(productId)){
            return ResponseEntity.status(201).body(new Logs("Product Successfully Deleted!", 201));
        }

        return ResponseEntity.status(400).body(new Logs("Error incorrect product Id", 400));
    }


}
