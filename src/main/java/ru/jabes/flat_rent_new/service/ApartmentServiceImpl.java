package ru.jabes.flat_rent_new.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jabes.flat_rent_new.dto.ApartmentDto;
import ru.jabes.flat_rent_new.entity.Apartment;
import ru.jabes.flat_rent_new.mapper.ApartmentMapper;
import ru.jabes.flat_rent_new.repository.ApartmentRepository;

@RequiredArgsConstructor
@Service
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentMapper apartmentMapper;
    private final ApartmentRepository apartmentRepository;

    @Override
    public ApartmentDto save(ApartmentDto dto) {
        Apartment entity = apartmentMapper.toEntity(dto);
        Apartment saveEntity = apartmentRepository.save(entity);
        return apartmentMapper.toDto(saveEntity);
    }


}
