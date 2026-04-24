package com.api.barber_shop.mappers;

import com.api.barber_shop.dtos.CustomerRequestDto;
import com.api.barber_shop.dtos.CustomerResponseDto;
import com.api.barber_shop.entities.CustomerEntity;

import java.time.LocalDateTime;

public class CustomerMapper {


    public static CustomerEntity toEntity(CustomerRequestDto requestDto){
        return  new CustomerEntity(
                null,
                requestDto.nameCustomer(),
                requestDto.emailCustomer(),
                requestDto.telephoneCustomer(),
                LocalDateTime.now()

        );
    }

    public static CustomerResponseDto toResponse(CustomerEntity entity){
        return  new CustomerResponseDto(
                entity.getId(),
                entity.getNameCustomer(),
                entity.getEmailCustomer(),
                entity.getTelephoneCustomer(),
                entity.getDateTimeResgistration()
        );
    }
}
