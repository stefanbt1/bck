package com.example.uikt_eshop.models.dto;

import lombok.Data;

@Data
public class MonitorDto {

    private String name;

    private Double price;

    private String backLightType;

    private String resolution;

    private Long powerInKw;

    private String color;

    private Long category;

    public MonitorDto() {
    }

    public MonitorDto(String name, Double price, String backLightType, String resolution, Long powerInKw, String color,Long category ) {
        this.name = name;
        this.price = price;
        this.backLightType=backLightType;
        this.resolution=resolution;
        this.color=color;
        this.powerInKw=powerInKw;
        this.category=category;
    }

}
