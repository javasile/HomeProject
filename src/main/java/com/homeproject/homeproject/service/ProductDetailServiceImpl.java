package com.homeproject.homeproject.service;

import com.homeproject.homeproject.exceptions.MyPersonalExceptionBad;
import com.homeproject.homeproject.exceptions.MyPersonalExceptionFound;
import com.homeproject.homeproject.model.ProductDetailDto;
import com.homeproject.homeproject.repository.ProductDetail;
import com.homeproject.homeproject.repository.ProductDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductDetailServiceImpl implements ProductDetailService {

    private final ProductDetailRepository productDetailRepository;

    @Override
    public List<ProductDetail> getAllProductDetailDto(){
        return productDetailRepository.findAll();
    }

    @Override
    public void createProductDetail(@Valid ProductDetailDto productDetailDto){
        Optional<ProductDetail> productDetailOp = productDetailRepository.findById(productDetailDto.getId());
        if(productDetailOp.isPresent()){
            throw new MyPersonalExceptionBad("Product Already Exists!");
        }
    }

    @Override
    public ProductDetail readProductDetailById(UUID id) {
        return productDetailRepository.findById(id)
                .orElseThrow(() -> new MyPersonalExceptionFound("Product Not Found!"));
    }

    @Override
    public ProductDetail updateProductDetail(ProductDetail productDetail) {
        this.readProductDetailById(productDetail.getId());
        return productDetailRepository.save(productDetail);
    }

    @Override
    public void deleteProductDetail(UUID id) {
        this.readProductDetailById(id);
        productDetailRepository.deleteById(id);
    }
}
