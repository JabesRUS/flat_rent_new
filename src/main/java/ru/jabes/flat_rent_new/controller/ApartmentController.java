package ru.jabes.flat_rent_new.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.jabes.flat_rent_new.dto.ApartmentDto;
import ru.jabes.flat_rent_new.service.ApartmentService;

@RestController
@RequestMapping("/apartment")
@RequiredArgsConstructor
public class ApartmentController {
    private final ApartmentService apartmentService;

    @PostMapping
    public ResponseEntity<ApartmentDto> createApartment(@RequestBody ApartmentDto apartmentDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(apartmentService.save(apartmentDto));
    }
}
