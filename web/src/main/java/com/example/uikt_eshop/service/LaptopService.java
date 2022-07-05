package com.example.uikt_eshop.service;

import com.example.uikt_eshop.models.dto.LaptopDto;
import com.example.uikt_eshop.models.dto.ProductDto;
import com.example.uikt_eshop.models.products.Laptop;

import java.util.List;
import java.util.Optional;

public interface LaptopService {

    List<Laptop> getLaptops();

    Laptop getLaptopById(Long id);

    Optional<Laptop> createLaptop(LaptopDto laptopDto);

    void updateLaptop(Long id, Double price);

    void deleteLaptop(Long id);
}
