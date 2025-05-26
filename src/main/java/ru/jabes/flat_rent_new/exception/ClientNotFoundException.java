package ru.jabes.flat_rent_new.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(Integer clientId) {
        super("Client not found with id: " + clientId);
    }
}
