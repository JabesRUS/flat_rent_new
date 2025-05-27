package ru.jabes.flat_rent_new.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.jabes.flat_rent_new.dto.AdvertDtoRq;
import ru.jabes.flat_rent_new.dto.AdvertDtoRsp;
import ru.jabes.flat_rent_new.entity.Advert;
import ru.jabes.flat_rent_new.mapper.AdvertMapper;
import ru.jabes.flat_rent_new.repository.AdvertRepository;

@Service
@RequiredArgsConstructor
public class AdvertServiceImpl implements AdvertService {

    private static final int FIRST_PAGE = 0;
    private static final int TEN_ENTRIES = 10;
    private static final String ORDER_BY_PRICE = "price";

    private final AdvertMapper advertMapper;
    private final AdvertRepository advertRepository;

    @Override
    public AdvertDtoRsp save(AdvertDtoRq advertDtoRq) {
        Advert entity = advertMapper.toEntity(advertDtoRq);
        Advert saveEntity = advertRepository.save(entity);

        return advertMapper.toDto(saveEntity);
    }

    public Page<AdvertDtoRsp> getAdvertsByCity(String city, Integer page, Integer size) {
        int numberPage = page == null ? FIRST_PAGE : page;
        int sizePage = size == null ? TEN_ENTRIES : size;

        PageRequest pageRequest = PageRequest.of(numberPage, sizePage,
                Sort.by(Sort.Direction.DESC, ORDER_BY_PRICE));
        Page<Advert> adverts = advertRepository.findByApartmentCityOrderByPriceDesc(city, pageRequest);
        return adverts.map(advertMapper::toDto);
    }
}
