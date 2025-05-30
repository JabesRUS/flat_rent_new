package ru.jabes.flat_rent_new.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jabes.flat_rent_new.entity.Advert;



@Repository
public interface AdvertRepository extends JpaRepository<Advert, Integer> {

    Page<Advert> findByApartmentCityOrderByPriceDesc(String city, Pageable pageable);
}
