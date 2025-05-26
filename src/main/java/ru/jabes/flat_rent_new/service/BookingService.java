package ru.jabes.flat_rent_new.service;

import ru.jabes.flat_rent_new.dto.BookingDtoRq;
import ru.jabes.flat_rent_new.dto.BookingDtoRsp;

public interface BookingService {
    BookingDtoRsp save(BookingDtoRq bookingDtoRq);
}
