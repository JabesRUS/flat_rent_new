package ru.jabes.flat_rent_new.validate;

import org.springframework.stereotype.Component;
import ru.jabes.flat_rent_new.dto.ApartmentDto;
import ru.jabes.flat_rent_new.dto.ValidationError;

import java.util.Optional;

@Component
public class ApartmentRequiredFieldHouseValidation implements FlatRentValidation<ApartmentDto>{
    @Override
    public Optional<ValidationError> execute(ApartmentDto apartmentDto) {
        if(apartmentDto.getHouseNumber() == null || apartmentDto.getHouseNumber().isBlank()) {
            return Optional.of(new ValidationError("apartment.houseNumber.missing",
                    "Номер дома обязателен"));
        }
        return Optional.empty();
    }
}
