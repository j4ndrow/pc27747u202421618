package com.campuslab.platform.u202421618.reservations.domain.exceptions;

/**  @author Jose Alejandro Tello Lima */
public class DuplicateReservationCodeException extends RuntimeException {
    public DuplicateReservationCodeException() {
        super("Reservation code already exists.");
    }
}
