package com.api.barber_shop.mappers;

import com.api.barber_shop.entities.ProductEntity;
import com.api.barber_shop.dtos.ProductRequestDto;
import com.api.barber_shop.dtos.ProductResponseDto;

public class ProductMapper {

    public static ProductEntity toEntity(ProductRequestDto requestDto){
        return new ProductEntity(
                null,
                requestDto.nameProduct(),
                requestDto.durationMinProduct(),
                requestDto.priceProduct(),
                requestDto.activeProcuct()
        );
    }

    public static ProductResponseDto toResponse(ProductEntity entity){
        return new ProductResponseDto(
                entity.getIdProduct(),
                entity.getNameProduct(),
                entity.getDurationMinProduct(),
                entity.getPriceProduct(),
                entity.getActiveProcuct()
        );
    }


}
