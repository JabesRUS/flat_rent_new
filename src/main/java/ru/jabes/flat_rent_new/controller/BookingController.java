package ru.jabes.flat_rent_new.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.jabes.flat_rent_new.dto.BookingDtoRq;
import ru.jabes.flat_rent_new.dto.BookingDtoRsp;
import ru.jabes.flat_rent_new.service.BookingService;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingDtoRsp> createBooking(@RequestBody BookingDtoRq bookingDtoRq) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookingService.save(bookingDtoRq));
    }

    @GetMapping()
    public ResponseEntity<Page<BookingDtoRsp>> getBookingsByEmail(@RequestParam String email,
                                                                  @RequestParam(required = false) Integer page,
                                                                  @RequestParam(required = false) Integer size) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookingService.findBookingByEmail(email, page, size));

    }
}
