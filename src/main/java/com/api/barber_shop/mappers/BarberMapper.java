package com.api.barber_shop.mappers;

import com.api.barber_shop.dtos.BarberRequestDto;
import com.api.barber_shop.dtos.BarberResponseDto;
import com.api.barber_shop.entities.BarberEntity;
import com.api.barber_shop.entities.enums.ActiveBarber;

public class BarberMapper {

    //Todo: tt
    public static BarberEntity toEntity(BarberRequestDto requestDto){
        return new BarberEntity(
                null,
                requestDto.nameBarber(),
                requestDto.specialtyBarber(),
                requestDto.activeBarber() != null
                        ? requestDto.activeBarber()
                        : ActiveBarber.ATIVO
        );
    }

    public static BarberResponseDto toResponse(BarberEntity entity){
        return new BarberResponseDto(
                entity.getId(),
                entity.getNameBarber(),
                entity.getSpecialtyBarber(),
                entity.getActiveBarber()
        );
    }
}
