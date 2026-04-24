package com.api.barber_shop.repositories;

import com.api.barber_shop.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {

    Optional<CustomerEntity> findByEmailCustomer(String emailCustomer);

    Optional<CustomerEntity> findByTelephoneCustomer(String telephoneCustomer);

    @Transactional
    void deleteByEmailCustomer(String emailCustomer);
}
