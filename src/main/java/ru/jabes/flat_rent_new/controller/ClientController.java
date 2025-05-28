package ru.jabes.flat_rent_new.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.jabes.flat_rent_new.service.ClientService;

@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @DeleteMapping("/{id}")
    public Boolean deleteClientById(@PathVariable Integer id) {
        return clientService.deleteClientById(id);
    }
}
