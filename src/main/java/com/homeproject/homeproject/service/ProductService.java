package com.homeproject.homeproject.service;

import com.homeproject.homeproject.model.ProductDto;
import com.homeproject.homeproject.repository.Product;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<Product> getAllProductDto();

    void createProduct(@Valid ProductDto productDto);

    Product readProductById(UUID id);

    void updateProduct(Product product);

    void deleteProduct(UUID id);


}
