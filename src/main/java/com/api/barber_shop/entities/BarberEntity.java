package com.api.barber_shop.entities;

import com.api.barber_shop.entities.enums.ActiveBarber;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "barber")
@Entity
public class BarberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_barber", nullable = false)
    private UUID id;

    @Column(name = "name_barber")
    private String nameBarber;

    @Column(name = "specialty_barber")
    private String specialtyBarber;

    @Enumerated(EnumType.STRING)
    @Column(name = "Active_barber")
    private ActiveBarber activeBarber;

}
