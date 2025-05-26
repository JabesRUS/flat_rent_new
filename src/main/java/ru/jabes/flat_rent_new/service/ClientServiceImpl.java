package ru.jabes.flat_rent_new.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jabes.flat_rent_new.dto.ClientDto;
import ru.jabes.flat_rent_new.entity.Client;
import ru.jabes.flat_rent_new.mapper.ClientMapper;
import ru.jabes.flat_rent_new.repository.ClientRepository;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientDto save(ClientDto dto) {
        Client entity = clientMapper.toEntity(dto);
        Client saveEntity = clientRepository.save(entity);

        return clientMapper.toDto(saveEntity);
    }
}
