package ru.jabes.flat_rent_new.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jabes.flat_rent_new.dto.BookingDtoRq;
import ru.jabes.flat_rent_new.dto.BookingDtoRsp;
import ru.jabes.flat_rent_new.entity.Booking;
import ru.jabes.flat_rent_new.mapper.BookingMapper;
import ru.jabes.flat_rent_new.repository.BookingRepository;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    public final BookingMapper bookingMapper;
    public final BookingRepository bookingRepository;

    @Override
    public BookingDtoRsp save(BookingDtoRq bookingDtoRq) {
        Booking entity = bookingMapper.toEntity(bookingDtoRq);
        Booking saveEntity = bookingRepository.save(entity);
        return bookingMapper.toDto(saveEntity);

        }
}
