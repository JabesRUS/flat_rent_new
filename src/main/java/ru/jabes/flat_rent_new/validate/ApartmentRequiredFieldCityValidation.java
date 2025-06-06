package ru.jabes.flat_rent_new.validate;

import org.springframework.stereotype.Component;
import ru.jabes.flat_rent_new.dto.ApartmentDto;
import ru.jabes.flat_rent_new.dto.ValidationError;

import java.util.Optional;

@Component
public class ApartmentRequiredFieldCityValidation implements FlatRentValidation<ApartmentDto>{
    @Override
    public Optional<ValidationError> execute(ApartmentDto apartmentDto) {
        if(apartmentDto.getCity() == null || apartmentDto.getCity().isBlank()) {
            return Optional.of(new ValidationError("apartment.city.missing", "Город обязателен"));
        }
        return Optional.empty();
    }
}
