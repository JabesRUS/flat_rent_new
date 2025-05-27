package ru.jabes.flat_rent_new.exception;

import java.time.LocalDate;

public class DateRangeIntersectionException extends RuntimeException {
    public DateRangeIntersectionException(LocalDate startDate, LocalDate endDate) {
        super("Date ranges overlap: %s - %s".formatted(startDate, endDate));
    }
}
