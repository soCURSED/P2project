package com.example.p2project.Cart;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController @RequiredArgsConstructor
@RequestMapping("api/v1/cart")
public class CartController {
    private final CartService cartService;


     @GetMapping("/")
     public ResponseEntity getCart(){
            return ResponseEntity.status(200).body(cartService.getCarts());

    }
}
