package com.example.uikt_eshop.models.dto;

import lombok.Data;

@Data
public class LaptopDto {

    private String name;

    private Double price;

    private String CPU;

    private String RAM;

    private String storage;

    private String GPU;

    private Long weightInKg;

    private String operatingSystem;

    private String dimensions;

    private Long category;

    public LaptopDto() {
    }

    public LaptopDto(String name, Double price, String CPU, String RAM, String storage, String GPU, Long weightInKg, String operatingSystem, String dimensions, Long category) {
        this.name = name;
        this.price = price;
        this.CPU = CPU;
        this.RAM = RAM;
        this.storage = storage;
        this.GPU = GPU;
        this.weightInKg = weightInKg;
        this.operatingSystem = operatingSystem;
        this.dimensions = dimensions;
        this.category = category;
    }
}
