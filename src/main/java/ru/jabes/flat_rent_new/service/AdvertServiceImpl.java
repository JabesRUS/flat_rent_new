package ru.jabes.flat_rent_new.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jabes.flat_rent_new.dto.AdvertDtoRq;
import ru.jabes.flat_rent_new.dto.AdvertDtoRsp;
import ru.jabes.flat_rent_new.entity.Advert;
import ru.jabes.flat_rent_new.mapper.AdvertMapper;
import ru.jabes.flat_rent_new.repository.AdvertRepository;

@Service
@RequiredArgsConstructor
public class AdvertServiceImpl implements AdvertService {

    private final AdvertMapper advertMapper;
    private final AdvertRepository advertRepository;

    @Override
    public AdvertDtoRsp save(AdvertDtoRq advertDtoRq) {
        Advert entity = advertMapper.toEntity(advertDtoRq);
        Advert saveEntity = advertRepository.save(entity);

        return advertMapper.toDto(saveEntity);
    }
}
