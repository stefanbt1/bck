package com.example.uikt_eshop.models.dto;

import lombok.Data;

@Data
public class MouseDto {

    private String name;

    private Double price;

    private String cableLength;

    private String cableType;

    private String DPIResolution;

    private Boolean isGaming;

    private Long category;

    public MouseDto() {
    }

    public MouseDto(String name, Double price, String cableLength, String cableType, String DPIResolution, Boolean isGaming, Long category) {
        this.name = name;
        this.price = price;
        this.cableLength = cableLength;
        this.cableType = cableType;
        this.DPIResolution = DPIResolution;
        this.isGaming = isGaming;
        this.category = category;
    }
}
