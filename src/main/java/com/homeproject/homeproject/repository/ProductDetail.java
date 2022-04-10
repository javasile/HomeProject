package com.homeproject.homeproject.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.UUID;

@Entity
@Table(name = "productDetail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetail {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid")
    @Column(columnDefinition = "BINARY(16)")
    @NotNull
    @NotBlank
    private UUID id;

    @Length(max = 256)
    @Column(name = "product_description")
    private String description;

    @Column(name = "product_price")
    @PositiveOrZero(message = "Value must be positive or 0!")
    private double price;

    @Column(name = "product_category")
    private String category;

    @Column(name = "product_qty")
    private int quantity;

    @Column(name = "product_weight")
    private double weight;

    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

}
