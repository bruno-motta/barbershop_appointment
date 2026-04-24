package com.api.barber_shop.controllers;

import com.api.barber_shop.dtos.ProductRequestDto;
import com.api.barber_shop.dtos.ProductResponseDto;
import com.api.barber_shop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @PostMapping("/cadastro")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto productRequestDto){
        ProductResponseDto product = productService.createProduct(productRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
}
