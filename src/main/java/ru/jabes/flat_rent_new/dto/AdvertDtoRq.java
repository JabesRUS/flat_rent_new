package ru.jabes.flat_rent_new.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
public class AdvertDtoRq {

    private Integer id;

    @NonNull
    private BigDecimal price;

    @NonNull
    @JsonProperty(value = "is_active")
    private Boolean isActive;

    @NonNull
    @JsonProperty(value = "apartment_id")
    private Integer ApartmentId;

    @NonNull
    private String description;
}
