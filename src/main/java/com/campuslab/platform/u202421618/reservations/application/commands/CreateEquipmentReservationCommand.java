package com.campuslab.platform.u202421618.reservations.application.commands;

import java.time.LocalDate;

public record CreateEquipmentReservationCommand(
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