package ru.jabes.flat_rent_new.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

@Data
public class ApartmentDto {

    private Integer id;

    @NonNull
    private String city;

    @NonNull
    private String street;

    @NonNull
    @JsonProperty(value = "house")
    private String houseNumber;

    @NonNull
    @JsonProperty(value = "apartment_type")
    private String roomCount;
}
