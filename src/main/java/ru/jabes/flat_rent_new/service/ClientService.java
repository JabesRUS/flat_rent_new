package ru.jabes.flat_rent_new.service;

import ru.jabes.flat_rent_new.dto.ClientDto;

public interface ClientService {
    ClientDto save(ClientDto dto);
    ClientDto checkClient(ClientDto client);
    Boolean deleteClientById(Integer id);
}
