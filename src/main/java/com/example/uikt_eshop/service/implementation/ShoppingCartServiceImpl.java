package com.example.uikt_eshop.service.implementation;

import com.example.uikt_eshop.models.Product;
import com.example.uikt_eshop.models.ShoppingCart;
import com.example.uikt_eshop.models.exceptions.ShoppingCartNotFoundException;
import com.example.uikt_eshop.repository.ShoppingCartRepository;
import com.example.uikt_eshop.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public List<Product> listAllProductsInShoppingCart(Long cartId) {
        if(this.shoppingCartRepository.findById(cartId).isEmpty())
            throw new ShoppingCartNotFoundException(cartId);
        return this.shoppingCartRepository.findById(cartId).get().getProducts();
    }

    @Override
    public ShoppingCart getActiveShoppingCart(Long id) {
        return shoppingCartRepository.findById(id).get();
    }

    @Override
    public ShoppingCart addProductToShoppingCart(String username, Long productId) {
        return null;
    }
}
