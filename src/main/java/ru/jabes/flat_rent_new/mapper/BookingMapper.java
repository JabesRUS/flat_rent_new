package ru.jabes.flat_rent_new.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import ru.jabes.flat_rent_new.dto.BookingDtoRq;
import ru.jabes.flat_rent_new.dto.BookingDtoRsp;
import ru.jabes.flat_rent_new.entity.Advert;
import ru.jabes.flat_rent_new.entity.Booking;
import ru.jabes.flat_rent_new.entity.Client;
import ru.jabes.flat_rent_new.exception.AdvertNotFoundException;
import ru.jabes.flat_rent_new.exception.ClientNotFoundException;
import ru.jabes.flat_rent_new.repository.AdvertRepository;
import ru.jabes.flat_rent_new.repository.ClientRepository;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class BookingMapper {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AdvertRepository advertRepository;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "client", source = "clientId", qualifiedByName = "getClientById")
    @Mapping(target = "advert", source = "advertId", qualifiedByName = "getAdvertById")
    public abstract Booking toEntity(BookingDtoRq dtoRq);

    @Named(value = "getAdvertById")
    protected Advert getAdvertById(Integer advertId) {
        return advertRepository.findById(advertId).orElseThrow(
                () -> new AdvertNotFoundException(advertId)
        );
    }

    @Named(value = "getClientById")
    protected Client getClientById(Integer clientId) {
        return clientRepository.findById(clientId).orElseThrow(
                () -> new ClientNotFoundException(clientId)
        );
    }

    public abstract BookingDtoRsp toDto(Booking entity);






}
