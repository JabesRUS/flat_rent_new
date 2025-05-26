package ru.jabes.flat_rent_new.mapper;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import ru.jabes.flat_rent_new.dto.AdvertDtoRq;
import ru.jabes.flat_rent_new.dto.AdvertDtoRsp;
import ru.jabes.flat_rent_new.entity.Advert;
import ru.jabes.flat_rent_new.entity.Apartment;
import ru.jabes.flat_rent_new.exception.ApartmentNotFoundException;
import ru.jabes.flat_rent_new.repository.ApartmentRepository;

import java.util.Optional;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class AdvertMapper {

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "bookingList", ignore = true)
    @Mapping(target = "apartment", source = "apartmentId", qualifiedByName = "getApartmentById")
    public abstract Advert toEntity(AdvertDtoRq dtoRq);

    @Named(value = "getApartmentById")
    protected Apartment getApartmentById(Integer apartmentId){
        return apartmentRepository.findById(apartmentId).orElseThrow(
                () -> new ApartmentNotFoundException(apartmentId)
        );
    }

    public abstract AdvertDtoRsp toDto(Advert entity);
}
