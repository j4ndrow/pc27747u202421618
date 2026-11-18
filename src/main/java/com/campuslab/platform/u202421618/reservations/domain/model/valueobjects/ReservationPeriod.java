package com.campuslab.platform.u202421618.reservations.domain.model.valueobjects;

import java.time.LocalDate;


public record ReservationPeriod(LocalDate startDate, LocalDate endDate) {
    public ReservationPeriod {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Both reservation dates are required.");
        }
        if (!endDate.isAfter(startDate)) {
            throw new IllegalArgumentException("End date must be after start date.");
        }
    }

    /** Checks whether checkDate is inside the period, including both ends.
     * @param checkDate date to check
     * @return true when the date is within the period
     */
    public boolean contains(LocalDate checkDate) {
        if (checkDate == null) throw new IllegalArgumentException("Check date must not be null.");
        return !checkDate.isBefore(startDate) && !checkDate.isAfter(endDate);
    }
}
