package ru.jabes.flat_rent_new.exception;

import lombok.Getter;
import ru.jabes.flat_rent_new.dto.ValidationError;

import java.util.List;

@Getter
public class ApartmentValidationException extends RuntimeException {

  private final List<ValidationError> errors;

  public ApartmentValidationException(List<ValidationError> errors) {
    super("Apartment validation failed");
    this.errors = errors;
  }

}
