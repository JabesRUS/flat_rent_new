package ru.jabes.flat_rent_new.service;

import org.springframework.data.domain.Page;
import ru.jabes.flat_rent_new.dto.BookingDtoRq;
import ru.jabes.flat_rent_new.dto.BookingDtoRsp;

public interface BookingService {
    BookingDtoRsp save(BookingDtoRq bookingDtoRq);

    Page<BookingDtoRsp> findBookingByEmail(String email, Integer page, Integer size);
}
