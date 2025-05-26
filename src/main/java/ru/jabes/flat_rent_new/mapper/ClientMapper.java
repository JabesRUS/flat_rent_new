package ru.jabes.flat_rent_new.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ru.jabes.flat_rent_new.dto.ClientDto;
import ru.jabes.flat_rent_new.entity.Client;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "bookingList", ignore = true)
    Client toEntity(ClientDto dto);

    ClientDto toDto(Client entity);
}
