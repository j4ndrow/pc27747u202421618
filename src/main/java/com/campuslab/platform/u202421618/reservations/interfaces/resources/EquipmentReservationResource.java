package com.campuslab.platform.u202421618.reservations.interfaces.resources;

import java.time.LocalDate;

/** Response returned after successfully creating a reservation.
 * @author Jose Alejandro Tello Lima
 */
public record EquipmentReservationResource(
        Long id,
        String reservationCode,
        String laboratoryId,
        LocalDate reservationPeriodStartDate,
        LocalDate reservationPeriodEndDate,
        Integer equipmentBatchQuantity,
        String equipmentBatchUnit,
        Integer accessLevel,
        String status,
        String reservationNotes
) {}
