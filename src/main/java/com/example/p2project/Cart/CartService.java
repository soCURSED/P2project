package com.example.p2project.Cart;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service @RequiredArgsConstructor
public class CartService {
    private ArrayList<Cart> cartList = new ArrayList<>();

    public ArrayList<Cart> getCarts(){
        return cartList;
    }







}
