package ru.jabes.flat_rent_new.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    public ResponseEntity<Page<AdvertDtoRsp>> getAdvertByCity(@RequestParam String city,
                                                              @RequestParam(required = false) Integer page,
                                                              @RequestParam(required = false) Integer size) {
        Page<AdvertDtoRsp> adverts = advertService.getAdvertsByCity(city, page, size);

        return ResponseEntity.status(HttpStatus.OK)
                .body(adverts);
    }
}
