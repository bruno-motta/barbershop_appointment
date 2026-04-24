package com.api.barber_shop.dtos;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ProductRequestDto(
        @NotBlank(message = "Nome não pode ser nulo.")
        String nameProduct,

        @NotBlank
        Integer durationMinProduct,

        @NotBlank(message = "Preço do serviço não pode ficar em branco")
        BigDecimal priceProduct,

        @NotBlank(message = "Definição so serviço não pode ficar em branco")
        Boolean activeProcuct

) {
}
