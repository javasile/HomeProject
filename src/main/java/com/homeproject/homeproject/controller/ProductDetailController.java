package com.homeproject.homeproject.controller;

import com.homeproject.homeproject.model.ProductDetailDto;
import com.homeproject.homeproject.repository.ProductDetail;
import com.homeproject.homeproject.service.ProductDetailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/productDetail")
@RequiredArgsConstructor
public class ProductDetailController {

    private final ProductDetailServiceImpl productDetailService;

    @GetMapping("/allProductDetail")
    @ResponseStatus(OK)
    public List<ProductDetail> findAllProductDetail() {
        return productDetailService.getAllProductDetailDto();
    }

    @PostMapping("/newProductDetail")
    public void createProductDetail(@RequestBody ProductDetailDto productDetailDto) {
        productDetailService.createProductDetail(productDetailDto);
    }

    @GetMapping("/productDetail/{id}")
    public ProductDetail readProductDetailById(@PathVariable("id") UUID id) {
        return productDetailService.readProductDetailById(id);
    }

    @PutMapping("/editProductDetail")
    public void updateProductDetail(@RequestBody ProductDetail productDetail) {
        productDetailService.updateProductDetail(productDetail);
    }

    @PatchMapping("/updateProductDetail")
    public void updateProductDetail2(@RequestBody ProductDetail productDetail) {
        productDetailService.updateProductDetail(productDetail);
    }

    @DeleteMapping("/deleteProductDetail/{id}")
    public void deleteProductDetail(@PathVariable UUID id) {
        productDetailService.deleteProductDetail(id);
    }

}
