package ru.jabes.flat_rent_new.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jabes.flat_rent_new.dto.ApartmentDto;
import ru.jabes.flat_rent_new.dto.ValidationError;
import ru.jabes.flat_rent_new.entity.Apartment;
import ru.jabes.flat_rent_new.exception.ApartmentValidationException;
import ru.jabes.flat_rent_new.mapper.ApartmentMapper;
import ru.jabes.flat_rent_new.repository.ApartmentRepository;
import ru.jabes.flat_rent_new.validate.ApartmentValidationService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentMapper apartmentMapper;
    private final ApartmentRepository apartmentRepository;
    private final ApartmentValidationService apartmentValidationService;

    @Override
    public ApartmentDto save(ApartmentDto dto) {
        List<ValidationError> errors = apartmentValidationService.validate(dto);
        if (!errors.isEmpty()) {
            throw new ApartmentValidationException(errors);
        }

        Apartment entity = apartmentMapper.toEntity(dto);
        Apartment saveEntity = apartmentRepository.save(entity);
        return apartmentMapper.toDto(saveEntity);
    }
}
