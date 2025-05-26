package ru.jabes.flat_rent_new.exception;

public class AdvertNotFoundException extends RuntimeException {
    public AdvertNotFoundException(Integer advertId) {
        super("Advert not found with id: " + advertId);
    }
}
