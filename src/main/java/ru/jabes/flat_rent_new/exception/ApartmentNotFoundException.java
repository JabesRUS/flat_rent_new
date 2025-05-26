package ru.jabes.flat_rent_new.exception;

public class ApartmentNotFoundException extends RuntimeException {
    public ApartmentNotFoundException(Integer apartmentId) {
        super("Apartment not found with id: " + apartmentId);
    }
}
