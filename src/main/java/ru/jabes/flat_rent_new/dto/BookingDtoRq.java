package ru.jabes.flat_rent_new.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
public class BookingDtoRq {

    private Integer id;

    @NonNull
    @JsonProperty(value = "client_id")
    private Integer clientId;

    @NonNull
    @JsonProperty(value = "advert_id")
    private Integer advertId;

    @NonNull
    @JsonProperty(value = "date_start")
    private LocalDate startDate;

    @NonNull
    @JsonProperty(value = "end_вate")
    private LocalDate endDate;
}
