package com.example.uikt_eshop.models.products;

import com.example.uikt_eshop.models.Category;
import com.example.uikt_eshop.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Monitor extends Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String backLightType;

    private String resolution;

    private Long powerInKw;

    private String color;

    public Monitor(String name, Double price, Category category, String backLightType, String resolution, Long powerInKw, String color) {
        super(name, price, category);
        this.backLightType=backLightType;
        this.resolution=resolution;
        this.powerInKw=powerInKw;
        this.color=color;
    }
}