package com.homeproject.homeproject.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    @NotNull
    private UUID id;

    @Length(max =36)
    @Column(name = "product_name", length = 36)
    @NotNull
    @NotBlank(message = "The product must have a name!")
    private String name;

    @Length(max =36)
    @Column(name = "product_sku", length = 36)
    @NotNull
    @NotBlank(message = "The product must have a sku!")
    private String sku;

    @OneToMany()
    @JoinTable(
            name = "product_productDetail",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "productDetail_id")
    )
    private List<ProductDetail> productDetail;

    @ManyToOne(cascade = CascadeType.ALL)
    private Order order;

}
