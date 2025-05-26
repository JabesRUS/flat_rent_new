package ru.jabes.flat_rent_new.service;

import ru.jabes.flat_rent_new.dto.ApartmentDto;
import ru.jabes.flat_rent_new.entity.Apartment;

public interface ApartmentService {

    ApartmentDto save(ApartmentDto dto);
}
