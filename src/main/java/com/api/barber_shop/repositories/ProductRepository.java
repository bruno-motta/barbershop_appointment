package com.api.barber_shop.repositories;

import com.api.barber_shop.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

    List<ProductEntity> findByNameProductContainingIgnoreCase(String nameService);

    List<ProductEntity> findByPriceProduct(BigDecimal priceProduct);
}
