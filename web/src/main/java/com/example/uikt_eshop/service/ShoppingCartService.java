package com.example.uikt_eshop.service;

import com.example.uikt_eshop.models.Product;
import com.example.uikt_eshop.models.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    ShoppingCart getShoppingCart(int id);
    List<Product> listAllProductsInShoppingCart(int id);
    void addProductToShoppingCart(int id, Long productId);
}
