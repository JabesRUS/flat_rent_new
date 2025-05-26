package ru.jabes.flat_rent_new.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NonNull;

@Data
public class ClientDto {

    private Integer id;

    @NonNull
    private String name;

    @NonNull
    private String email;
}
