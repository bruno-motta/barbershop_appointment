package com.api.barber_shop.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponseDto(UUID id, String nameProduct, Integer durationMinProduct, BigDecimal priceProduct, Boolean activeProcuct) {
}
