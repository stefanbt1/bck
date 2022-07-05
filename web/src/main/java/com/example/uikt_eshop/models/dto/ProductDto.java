package com.example.uikt_eshop.models.dto;

import lombok.Data;

@Data
public class ProductDto {
    private String name;
    private Double price;
    private Long category;


    public ProductDto(String name, Double price, Long category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
