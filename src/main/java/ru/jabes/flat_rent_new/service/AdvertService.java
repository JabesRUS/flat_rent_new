package ru.jabes.flat_rent_new.service;

import org.springframework.data.domain.Page;
import ru.jabes.flat_rent_new.dto.AdvertDtoRq;
import ru.jabes.flat_rent_new.dto.AdvertDtoRsp;

public interface AdvertService {
    AdvertDtoRsp save(AdvertDtoRq advertDtoRq);

    Page<AdvertDtoRsp> getAdvertsByCity(String city, Integer page, Integer size);
}
