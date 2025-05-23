package ru.jabes.flat_rent_new.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jabes.flat_rent_new.entity.Apartment;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {
}
