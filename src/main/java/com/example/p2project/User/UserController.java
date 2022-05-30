package com.example.p2project.User;


import com.example.p2project.Cart.Cart;
import com.example.p2project.Comment.Comment;
import com.example.p2project.Logs.Logs;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;


@RestController @RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController
{

    private final UserService userService;

    //get user
    @GetMapping("/")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(200).body(userService.getUsers());
    }

    //get history
    @GetMapping("history")
    public ResponseEntity getPurchaseHistory(){
        return ResponseEntity.status(200).body(userService.getPurchaseHistory());
    }

    //get comments
    @GetMapping("/all/comments")
    public ResponseEntity getComments(String prodId){

        ArrayList comments = userService.getComments(prodId);
        if( comments != null)
        {
            return ResponseEntity.status(200).body(comments);
        }

        return ResponseEntity.status(400).body(new Logs("Error incorrect userId!", 400));
    }


    //get rating
    @GetMapping("/rate")
    public ResponseEntity getFiveStarsRated(){

        return ResponseEntity.status(200).body(userService.getFiveStarsRated());

    }

    /*********************************************************************************************************************/
    /*********************************************************************************************************************/
    /*********************************************************************************************************************/

    //add
    @PostMapping("/")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors error){
        if(error.hasErrors())
        {
            return ResponseEntity.status(400).body(new Logs("Error incorrect Data!", 400, error.getFieldError().getDefaultMessage()));
        }

        userService.addUser(user);
        return ResponseEntity.status(201).body(new Logs("Successfully added user", 201));
    }

    //update
    @PutMapping("/{index}")
    public ResponseEntity updateUser(@RequestBody @Valid User user, @PathVariable Integer index, Errors error){
        if(error.hasErrors())
        {
            return ResponseEntity.status(400).body(new Logs("Error incorrect Data!", 400, error.getFieldError().getDefaultMessage()));
        }
        else if (userService.updateUser(index, user))
        {
            return ResponseEntity.status(201).body(new Logs("Successfully updated user", 201));
        }

        return ResponseEntity.status(400).body(new Logs("Error incorrect Index!", 400));
    }



    //update stock
    @PutMapping("/add/to/stock")
    public ResponseEntity addToMerchantStock(@RequestParam String productId,@RequestParam String merchantId, @RequestParam Integer amount){
        Integer addStatus = userService.addToMerchantStock(productId, merchantId,amount);
        if(addStatus == 0){
            return ResponseEntity.status(201).body(new Logs("Successfully added to to merchant stock", 201));
        }
        else if (addStatus == -1)
        {
            return ResponseEntity.status(400).body(new Logs("Error incorrect merchantId!", 400));
        }

        return ResponseEntity.status(400).body(new Logs("Error incorrect productId!", 400));
    }


    //delete
    @DeleteMapping("/")
    public ResponseEntity deleteUser(@RequestParam String userId){
        if(userService.deleteUser(userId))
        {
            return ResponseEntity.status(201).body(new Logs("Successfully delete user", 201));
        }

        return ResponseEntity.status(400).body(new Logs("Error incorrect userId!", 400));
    }

    //update comment
    @PutMapping("/comment/{userId}/{prodId}")
    public ResponseEntity commentPost(Errors error, @PathVariable String userId,@PathVariable String prodId,@RequestBody Comment comment){
        Integer commentStatus = userService.commentPost(userId, prodId, comment);
        if(error.hasErrors()){
            return ResponseEntity.status(400).body(new Logs("Error incorrect Data!", 400, error.getFieldError().getDefaultMessage()));
        }
        switch (commentStatus) {
            case 1 :
                ResponseEntity.status(400).body(new Logs("Error incorrect userId!", 400));
            case -1 :
                ResponseEntity.status(400).body(new Logs("Not purchased!", 400));
            case 0 :
                ResponseEntity.status(200).body(new Logs("Comment Added!", 200));
            default :
                ResponseEntity.status(404).body(new Logs("ERROR!", 404));
        }

        return null;
    }

    //update purchase
    @PutMapping("/purchase")
    public ResponseEntity directPurchase(@RequestParam String userId, @RequestParam  String productId, @RequestParam String merchantId) {
        Integer purchaseStatus = userService.directPurchase(userId, productId, merchantId);

        switch (purchaseStatus) {
            case 0:
                ResponseEntity.status(201).body(new Logs("Successfully purchased", 201));
            case 1:
                ResponseEntity.status(400).body(new Logs("Error incorrect merchantId!", 400));
            case -1:
                ResponseEntity.status(400).body(new Logs("Not found in Stick", 400));
            case 2:
                ResponseEntity.status(400).body(new Logs("Error incorrect productId!", 400));
            case 3:
                ResponseEntity.status(400).body(new Logs("Error incorrect userId!", 400));
            default:
                ResponseEntity.status(404).body(new Logs("ERROR!", 404));
        }

        return null;
    }


    //update cart
    @PutMapping("/add/to/cart")
    public ResponseEntity addToCart(@RequestParam String userId,@RequestParam String productId){
        Integer addStatus = userService.addToCart(userId, productId);
        if(addStatus == 0){
            return ResponseEntity.status(201).body(new Logs("Successfully added to cart", 201));
        }
        else if (addStatus == -1)
        {
            return ResponseEntity.status(400).body(new Logs("Error incorrect productId!", 400));
        }

        return ResponseEntity.status(400).body(new Logs("Error incorrect userId!", 400));
    }

    //update cart/purchase
    @PutMapping("/cart/purchase")
    public ResponseEntity purchaseCart(@RequestBody @Valid Cart cart, Errors error){
        Integer cartStatus = userService.purchaseCart(cart);

        if(error.hasErrors())
        {
            return ResponseEntity.status(400).body(new Logs("Error incorrect Data!", 400, error.getFieldError().getDefaultMessage()));
        }

        switch (cartStatus) {
            case 1 :
                ResponseEntity.status(201).body(new Logs("Successfully purchased", 201));
            case -1 :
                ResponseEntity.status(400).body(new Logs("Not Enough Cash!", 400));
            case 0 :
                ResponseEntity.status(400).body(new Logs("Stock is Empty!", 400));
            default :
                ResponseEntity.status(404).body(new Logs("ERROR!", 404));
        }
        return null;
    }





}
