package com.api.barber_shop.repositories;

import com.api.barber_shop.entities.BarberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BarberRepository extends JpaRepository<BarberEntity, UUID> {


    List<BarberEntity> findByNameBarberContainingIgnoreCase(String nameBarber);

    List<BarberEntity> findBySpecialtyBarberContainingIgnoreCase(String specialtyBarber);

    List<BarberEntity> findByNameBarberContainingIgnoreCaseAndSpecialtyBarberContainingIgnoreCase(String name, String epecialty);


    List<BarberEntity> id(UUID id);
}
