package com.example.p2project.Merchent;

import com.example.p2project.Logs.Logs;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController @RequiredArgsConstructor
@RequestMapping("api/v1/merchant")
public class MerchantController {
    private final MerchantService MerchantService;

    //get
    @GetMapping("/")
    public ResponseEntity getMerchant()
    {
        return ResponseEntity.status(200).body(MerchantService.getMerchants());
    }

    //add
    @PostMapping("/")

    public ResponseEntity addMerchant(@RequestBody @Valid Merchant merchant, Errors error){
        if(error.hasErrors())

        {

            return ResponseEntity.status(400).body(new Logs("Error incorrect Data", 400, error.getFieldError().getDefaultMessage()));
        }


        MerchantService.addMerchant(merchant);
        return ResponseEntity.status(201).body(new Logs("Merchant Successfully Added!", 201));
    }


    //update
    @PutMapping("/{index}")
    public ResponseEntity updateMerchant(@RequestBody @Valid Merchant merchant, @PathVariable Integer index, Errors error){
        if(error.hasErrors()){
            return ResponseEntity.status(400).body(new Logs("Error incorrect Data", 400, error.getFieldError().getDefaultMessage()));
        }

        else if (MerchantService.updateMerchant(index, merchant))
        {

            return ResponseEntity.status(201).body(new Logs("Merchant Successfully Updated!", 201));
        }

        return ResponseEntity.status(400).body(new Logs("Error incorrect Index", 400));
    }



    //delete
    @DeleteMapping("/")
    public ResponseEntity deleteMerchant(@RequestParam String merchantId){

        if(MerchantService.deleteMerchant(merchantId)){
            return ResponseEntity.status(201).body(new Logs(
                    "Merchant Successfully Delete!", 201));
        }

        return ResponseEntity.status(400).body(new Logs("Error incorrect Merchant Id", 400));
    }


}
