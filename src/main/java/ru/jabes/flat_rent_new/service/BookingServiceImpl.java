package ru.jabes.flat_rent_new.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jabes.flat_rent_new.dto.BookingDtoRq;
import ru.jabes.flat_rent_new.dto.BookingDtoRsp;
import ru.jabes.flat_rent_new.dto.ClientDto;
import ru.jabes.flat_rent_new.entity.Advert;
import ru.jabes.flat_rent_new.entity.Booking;
import ru.jabes.flat_rent_new.exception.AdvertNotFoundException;
import ru.jabes.flat_rent_new.exception.DateRangeIntersectionException;
import ru.jabes.flat_rent_new.mapper.BookingMapper;
import ru.jabes.flat_rent_new.repository.AdvertRepository;
import ru.jabes.flat_rent_new.repository.BookingRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private static final int FIRST_PAGE = 0;
    private static final int TWENTY_ENTRIES = 20;
    public final BookingMapper bookingMapper;
    public final BookingRepository bookingRepository;
    public final AdvertRepository advertRepository;
    public final ClientService clientService;

    @Override
    @Transactional
    public BookingDtoRsp save(BookingDtoRq bookingDtoRq) {
        ClientDto clientDto = clientService.checkClient(bookingDtoRq.getClient());
        bookingDtoRq.setClient(clientDto);

        checkDates(bookingDtoRq);

        BigDecimal totalPrice = calculateTotalPrice(bookingDtoRq);

        Booking entity = bookingMapper.toEntity(bookingDtoRq, totalPrice);
        Booking saveEntity = bookingRepository.save(entity);

        return bookingMapper.toDto(saveEntity);

    }

    public Page<BookingDtoRsp> findBookingByEmail(String email, Integer page, Integer size) {
        int numberPage = page == null ? FIRST_PAGE : page;
        int sizePage = size == null ? TWENTY_ENTRIES : size;

        PageRequest pageRequest = PageRequest.of(numberPage, sizePage);
        Page<Booking> bookingsPage = bookingRepository.findByClientEmail(email, pageRequest);

        return bookingsPage.map(bookingMapper::toDto);
    }

    private void checkDates(BookingDtoRq bookingDtoRq) {
        Integer advertId = bookingDtoRq.getAdvertId();
        LocalDate startRequestDate = bookingDtoRq.getStartDate();
        LocalDate endRequestDate = bookingDtoRq.getEndDate();
//        Получаем объявление из БД
        Advert advert = advertRepository.findById(advertId)
                .orElseThrow(() -> new AdvertNotFoundException(advertId));
//        Получаем список Bookings из advert
        List<Booking> bookings = advert.getBookingList();
//      Получаем количество пересечений
        long countIntersections = bookings.stream()
                .filter(booking -> checkIntersections(booking.getStartDate(), booking.getEndDate(),
                        startRequestDate, endRequestDate))
                .count();

        if (countIntersections > 0) {
            throw new DateRangeIntersectionException(startRequestDate, endRequestDate);
        }

    }

    private boolean checkIntersections(LocalDate startDateAdvert, LocalDate endDateAdvert,
                                       LocalDate startRequestDate, LocalDate endRequestDate) {
//        return !startDateAdvert.isAfter(endRequestDate) && !startRequestDate.isAfter(endDateAdvert);
//        start1.isBefore(end2) && start2.isBefore(end1)
        return startDateAdvert.isBefore(endRequestDate) && startRequestDate.isBefore(endDateAdvert);
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
