package com.example.uikt_eshop.service;

import com.example.uikt_eshop.models.Product;
import com.example.uikt_eshop.models.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();

    Optional<Product> findById(Long id);

    Optional<Product> findByName(String name);

    Optional<Product> save(ProductDto productDto);

    Optional<Product> edit(Long id, Double price);

    void deleteById(Long id);
}
