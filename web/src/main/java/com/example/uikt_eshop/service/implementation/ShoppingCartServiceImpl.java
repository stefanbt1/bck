package com.example.uikt_eshop.service.implementation;

import com.example.uikt_eshop.models.Product;
import com.example.uikt_eshop.models.ShoppingCart;
import com.example.uikt_eshop.models.exceptions.EntityNotFoundException;
import com.example.uikt_eshop.repository.ProductRepository;
import com.example.uikt_eshop.repository.ShoppingCartRepository;
import com.example.uikt_eshop.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ShoppingCart getShoppingCart(int id) {
        return this.shoppingCartRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cart is not found"));
    }

    @Override
    public List<Product> listAllProductsInShoppingCart(int id) {
        return this.shoppingCartRepository.findById(id).get().getProducts();
    }


    @Override
    public void addProductToShoppingCart(int id, Long productId) {
        ShoppingCart shoppingCart = this.shoppingCartRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Product productToAdd = this.productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        List<Product> productsInCart = shoppingCart.getProducts();
        productsInCart.add(productToAdd);
        shoppingCart.setProducts(productsInCart);

        this.shoppingCartRepository.save(shoppingCart);
    }
}
