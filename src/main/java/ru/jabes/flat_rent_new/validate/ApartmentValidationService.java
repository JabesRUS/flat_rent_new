package ru.jabes.flat_rent_new.validate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.jabes.flat_rent_new.dto.ApartmentDto;
import ru.jabes.flat_rent_new.dto.ValidationError;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ApartmentValidationService {

    private final List<FlatRentValidation<ApartmentDto>> validations;

    public List<ValidationError> validate(ApartmentDto apartmentDto) {
        return validations.stream()
                .map(validate -> validate.execute(apartmentDto))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();


    }

}
