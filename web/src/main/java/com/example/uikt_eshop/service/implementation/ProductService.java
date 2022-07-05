package com.example.uikt_eshop.service.implementation;

import com.example.uikt_eshop.models.Category;
import com.example.uikt_eshop.models.Product;
import com.example.uikt_eshop.models.ShoppingCart;
import com.example.uikt_eshop.models.dto.ProductDto;
import com.example.uikt_eshop.models.exceptions.EntityNotFoundException;
import com.example.uikt_eshop.repository.CategoryRepository;
import com.example.uikt_eshop.repository.ProductRepository;
import com.example.uikt_eshop.repository.ShoppingCartRepository;
import com.example.uikt_eshop.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ShoppingCartRepository cartRepository;

    @Override
    public List<Product> findAll() {

        if(!this.cartRepository.existsById(1)){
            ShoppingCart cart = new ShoppingCart();
            cartRepository.saveAndFlush(cart);
        }

        return this.productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return this.productRepository.findByName(name);
    }

    @Override
    public Optional<Product> save(ProductDto productDto) {
        Category category = this.categoryRepository.findById(productDto.getCategory())
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        this.productRepository.deleteByName(productDto.getName());

        Product product = new Product(productDto.getName(), productDto.getPrice(),
                category);

        this.productRepository.save(product);

        return Optional.of(product);
    }

    @Override
    public Optional<Product> edit(Long id, Double price) {
        Product product = this.productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Product not found"));

        product.setPrice(price);

        this.productRepository.save(product);
        return Optional.of(product);

    }

    @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }

}
