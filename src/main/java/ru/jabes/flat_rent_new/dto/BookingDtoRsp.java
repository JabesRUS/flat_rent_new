package ru.jabes.flat_rent_new.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BookingDtoRsp {

    private Integer id;

    @JsonProperty(value = "client")
    private ClientDto client;

    @JsonProperty(value = "advert")
    private AdvertDtoRsp advert;

    @JsonProperty(value = "date_start")
    private LocalDate startDate;

    @JsonProperty(value = "date_end")
    private LocalDate endDate;

    @JsonProperty(value = "result_price")
    private BigDecimal totalPrice;
}
