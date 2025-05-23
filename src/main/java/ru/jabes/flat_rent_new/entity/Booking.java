package ru.jabes.flat_rent_new.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name= "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "client_id", nullable = false)
    private String clientId;

    @Column(name = "advert_id", nullable = false)
    private String advertId;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;
}
