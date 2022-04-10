package com.homeproject.homeproject.service;

import com.homeproject.homeproject.exceptions.MyPersonalExceptionBad;
import com.homeproject.homeproject.exceptions.MyPersonalExceptionFound;
import com.homeproject.homeproject.model.ProductDto;
import com.homeproject.homeproject.repository.Product;
import com.homeproject.homeproject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Validated
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProductDto() {
        return productRepository.findAll();
    }

    @Override
    public void createProduct(ProductDto productDto) {
        Optional<Product> productOp = productRepository.findById(productDto.getId());
        if (productOp.isPresent()) {
            throw new MyPersonalExceptionBad("Product Already Exists!");
        }
    }

    @Override
    public Product readProductById(UUID id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new MyPersonalExceptionFound("Product Not Found!"));
    }

    @Override
    public void updateProduct(Product product) {
        this.readProductById(product.getId());
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(UUID id) {
        this.readProductById(id);
        productRepository.deleteById(id);
    }

}
