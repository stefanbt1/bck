package com.example.uikt_eshop.web;


import com.example.uikt_eshop.models.ShoppingCart;
import com.example.uikt_eshop.models.dto.CartDto;
import com.example.uikt_eshop.service.ShoppingCartService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/shoppingCart")
public class ShoppingCartController {


    private final ShoppingCartService shoppingCartService;


    @GetMapping("/{id}")
    public ShoppingCart getShoppingCart(@PathVariable Long id){
        return this.shoppingCartService.getShoppingCart(id.intValue());
    }

    @PostMapping("/add-product/{id}")
    public void addProductToShoppingCart(@PathVariable Long id,
                                         @RequestBody CartDto cartDto){

        this.shoppingCartService
                .addProductToShoppingCart(id.intValue(), cartDto.getProductId());
    }
}
