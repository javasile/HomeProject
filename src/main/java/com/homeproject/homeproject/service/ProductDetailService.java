package com.homeproject.homeproject.service;

import com.homeproject.homeproject.model.ProductDetailDto;
import com.homeproject.homeproject.repository.ProductDetail;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface ProductDetailService {
    List<ProductDetail> getAllProductDetailDto();

    void createProductDetail(@Valid ProductDetailDto productDetailDto);

    ProductDetail readProductDetailById(UUID id);

    ProductDetail updateProductDetail(ProductDetail productDetail);

    void deleteProductDetail(UUID id);
}
