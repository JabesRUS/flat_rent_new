package ru.jabes.flat_rent_new.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.jabes.flat_rent_new.dto.AdvertDtoRq;
import ru.jabes.flat_rent_new.dto.AdvertDtoRsp;
import ru.jabes.flat_rent_new.service.AdvertService;

@RestController
@RequestMapping("/advert")
@RequiredArgsConstructor
public class AdvertController {

    private final AdvertService advertService;

    @PostMapping
    public ResponseEntity<AdvertDtoRsp> createAdvert(@RequestBody AdvertDtoRq advertDtoRq) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(advertService.save(advertDtoRq));
    }
}
