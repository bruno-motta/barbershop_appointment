package com.api.barber_shop.dtos;

import com.api.barber_shop.entities.enums.ActiveBarber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BarberRequestDto(
        @NotBlank(message = "O nome é obrigatorio.")
        @Size(max = 100, message = "Tamanho máximo permito.")
        String nameBarber,

        @Size(max = 250, message = "Tamanho máximo permitido.")
        String specialtyBarber,

        ActiveBarber activeBarber

) {
}
