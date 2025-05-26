package ru.jabes.flat_rent_new.service;

import ru.jabes.flat_rent_new.dto.AdvertDtoRq;
import ru.jabes.flat_rent_new.dto.AdvertDtoRsp;

public interface AdvertService {
    AdvertDtoRsp save(AdvertDtoRq advertDtoRq);
}
