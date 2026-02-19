package com.api.barber_shop.services;

import com.api.barber_shop.entities.ProductEntity;
import com.api.barber_shop.repositories.ProductRepository;
import com.api.barber_shop.dtos.ProductRequestDto;
import com.api.barber_shop.dtos.ProductResponseDto;
import com.api.barber_shop.mappers.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductService{

    private final ProductRepository productRepository;

    public ProductResponseDto createProduct(ProductRequestDto productRequestDto){
        validateProduct(productRequestDto);

        ProductEntity entity = ProductMapper.toEntity(productRequestDto);
        ProductEntity response = productRepository.save(entity);

        return ProductMapper.toResponse(response);
    }

    private void validateProduct(ProductRequestDto dto){
        if(dto.nameProduct() == null || dto.nameProduct().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O nome do serviço é obrigatório!");
        }

        if(dto.priceProduct() == null || dto.priceProduct().compareTo(BigDecimal.ZERO) <= 0){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "O preço deve ser maior que zero!");

        }

        if(dto.durationMinProduct() == null || dto.durationMinProduct() <= 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A duração do serviço não pode ser menor que zero!");
        }
    }

}
