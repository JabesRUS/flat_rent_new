package ru.jabes.flat_rent_new.validate;

import org.springframework.stereotype.Component;
import ru.jabes.flat_rent_new.dto.ApartmentDto;
import ru.jabes.flat_rent_new.dto.ValidationError;

import java.util.Optional;

@Component
public class ApartmentRequiredFieldApartmentTypeValidation implements FlatRentValidation<ApartmentDto>{
    @Override
    public Optional<ValidationError> execute(ApartmentDto apartmentDto) {
        if (apartmentDto.getRoomCount() == null) {
            return Optional.of(new ValidationError("apartment.apartmentType.missing",
                    "Количество комнат обязательно"));
        }
        return Optional.empty();
    }
}
