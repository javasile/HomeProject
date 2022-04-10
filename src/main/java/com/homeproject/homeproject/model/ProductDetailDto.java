package com.homeproject.homeproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailDto {

    private UUID id;
    private String description;
    private double price;
    private String category;
    private int quantity;
    private double weight;

}
