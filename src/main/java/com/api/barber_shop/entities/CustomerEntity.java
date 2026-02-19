package com.api.barber_shop.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "customer")
@Entity
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id", nullable = false)
    private UUID id;

    @Column(name = "name_customer")
    private String nameCustomer;

    @Column(name = "email_customer")
    private String emailCustomer;

    @Column(name = "telephone_customer")
    private String telephoneCustomer;

    @Column(name = "data_Time_Registration")
    private LocalDateTime dateTimeResgistration = LocalDateTime.now();


}
