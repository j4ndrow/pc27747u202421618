package com.campuslab.platform.u202421618.reservations.domain.model.valueobjects;

public record ReservationCode(String code) {
    public ReservationCode {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Reservation code must not be blank.");
        }
    }
}
