package ru.jabes.flat_rent_new.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AdvertDtoRsp {

    private Integer id;
    private BigDecimal price;

    @JsonProperty(value = "is_active")
    private Boolean isActive;

    private ApartmentDto apartment;

    private String description;
}
