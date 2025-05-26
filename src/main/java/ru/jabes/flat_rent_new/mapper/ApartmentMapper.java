package ru.jabes.flat_rent_new.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ru.jabes.flat_rent_new.dto.ApartmentDto;
import ru.jabes.flat_rent_new.entity.Apartment;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApartmentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "advertList", ignore = true)
    Apartment toEntity(ApartmentDto dto);

    ApartmentDto toDto(Apartment entity);
}
