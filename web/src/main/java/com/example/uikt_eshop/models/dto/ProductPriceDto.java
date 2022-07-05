package com.example.uikt_eshop.models.dto;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class ProductPriceDto {

    private Double price;

    public ProductPriceDto() {
    }

    public ProductPriceDto(Double price) {
        this.price = price;
    }
}
