package ru.jabes.flat_rent_new.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jabes.flat_rent_new.dto.BookingDtoRq;
import ru.jabes.flat_rent_new.dto.BookingDtoRsp;
import ru.jabes.flat_rent_new.entity.Advert;
import ru.jabes.flat_rent_new.entity.Booking;
import ru.jabes.flat_rent_new.exception.AdvertNotFoundException;
import ru.jabes.flat_rent_new.mapper.BookingMapper;
import ru.jabes.flat_rent_new.repository.AdvertRepository;
import ru.jabes.flat_rent_new.repository.BookingRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    public final BookingMapper bookingMapper;
    public final BookingRepository bookingRepository;
    public final AdvertRepository advertRepository;

    @Override
    public BookingDtoRsp save(BookingDtoRq bookingDtoRq) {
        BigDecimal totalPrice = calculateTotalPrice(bookingDtoRq);
        Booking entity = bookingMapper.toEntity(bookingDtoRq, totalPrice);
        Booking saveEntity = bookingRepository.save(entity);

        return bookingMapper.toDto(saveEntity);

    }

    private BigDecimal calculateTotalPrice(BookingDtoRq bookingDtoRq) {
        Integer advertId = bookingDtoRq.getAdvertId();
        Advert advert = advertRepository.findById(advertId).orElseThrow(
                () -> new AdvertNotFoundException(advertId)
        );
        BigDecimal price = advert.getPrice();
        LocalDate startDate = bookingDtoRq.getStartDate();
        LocalDate endDate = bookingDtoRq.getEndDate();
        BigDecimal betweenDays = BigDecimal.valueOf(ChronoUnit.DAYS.between(startDate, endDate));

        return betweenDays.multiply(price);
    }

}
