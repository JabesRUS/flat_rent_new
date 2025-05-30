package ru.jabes.flat_rent_new.validate;

import ru.jabes.flat_rent_new.dto.ValidationError;

import java.util.Optional;

public interface FlatRentValidation<T> {
    Optional<ValidationError> execute(T dto);
}
