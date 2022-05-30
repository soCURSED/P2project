package com.example.p2project.MerchentStock;

import com.example.p2project.Logs.Logs;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController @RequiredArgsConstructor
@RequestMapping("api/v1/MerchantStock")
public class MerchantStockController {
    private final MerchantStockService merchantStockService;

    //get
    @GetMapping("/")
    public ResponseEntity getMerchantStocks()
    {
        return ResponseEntity.status(200).body(merchantStockService.getMerchantStocks());

    }

    //add
    @PostMapping("/")
    public ResponseEntity addMerchantStock(@RequestBody @Valid MerchantStock merchantStock, Errors error)
    {
        if(error.hasErrors())
        {

            return ResponseEntity.status(400).body(new Logs("Error incorrect Data", 400, error.getFieldError().getDefaultMessage()));

        }

        merchantStockService.addMerchantStock(merchantStock);
        return ResponseEntity.status(201).body(new Logs("MerchantStock Successfully Added!", 201));
    }

    //update
    @PutMapping("/{index}")
    public ResponseEntity updateMerchantStock(@RequestBody @Valid MerchantStock merchantStock, @PathVariable Integer index, Errors error)
    {
        if(error.hasErrors())
        {
            return ResponseEntity.status(400).body(new Logs("Error incorrect Data", 400, error.getFieldError().getDefaultMessage()));
        }
        else if (merchantStockService.updateMerchantStock(index, merchantStock))
        {
            return ResponseEntity.status(201).body(new Logs("MerchantStock Successfully Updated!", 201));
        }
        return ResponseEntity.status(400).body(new Logs("Error incorrect Index", 400));
    }


    //delete
    @DeleteMapping("/")
    public ResponseEntity deleteMerchantStock(@RequestParam String merchantStockId){
        if(merchantStockService.deleteMerchantStocks(merchantStockId))
        {
            return ResponseEntity.status(201).body(new Logs("MerchantStock Successfully Delete!", 201));
        }

        return ResponseEntity.status(400).body(new Logs("Error incorrect MerchantStock id", 400));
    }


}
