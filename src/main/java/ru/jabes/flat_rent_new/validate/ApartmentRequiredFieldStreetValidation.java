package ru.jabes.flat_rent_new.validate;

import org.springframework.stereotype.Component;
import ru.jabes.flat_rent_new.dto.ApartmentDto;
import ru.jabes.flat_rent_new.dto.ValidationError;

import java.util.Optional;

@Component
public class ApartmentRequiredFieldStreetValidation implements FlatRentValidation<ApartmentDto>{
    @Override
    public Optional<ValidationError> execute(ApartmentDto apartmentDto) {
        if(apartmentDto.getStreet() == null || apartmentDto.getStreet().isBlank()) {
            return Optional.of(new ValidationError("apartment.street.missing", "Улица обязательна"));
        }
        return Optional.empty();
    }
}
