package com.homeproject.homeproject.controller;

import com.homeproject.homeproject.model.ProductDto;
import com.homeproject.homeproject.repository.Product;
import com.homeproject.homeproject.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;

    @GetMapping("/allProduct")
    @ResponseStatus(OK)
    public List<Product> findAllProduct() {
        return productService.getAllProductDto();
    }

    @PostMapping("/newProduct")
    public void createProduct(@RequestBody ProductDto productDto) {
        productService.createProduct(productDto);
    }

    @GetMapping(value = "/product/{id}")
    public Product readProductById(@PathVariable("id") UUID id) {
        return productService.readProductById(id);
    }

    @PutMapping("/editProduct")
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }

    @PatchMapping("/updateProduct")
    public void updateProduct2(@RequestBody Product product) {
        productService.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
    }
}
