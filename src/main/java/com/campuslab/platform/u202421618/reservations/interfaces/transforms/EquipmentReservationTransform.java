package com.campuslab.platform.u202421618.reservations.interfaces.transforms;

import com.campuslab.platform.u202421618.reservations.application.commands.CreateEquipmentReservationCommand;
import com.campuslab.platform.u202421618.reservations.domain.model.aggregates.EquipmentReservation;
import com.campuslab.platform.u202421618.reservations.interfaces.resources.CreateEquipmentReservationResource;
import com.campuslab.platform.u202421618.reservations.interfaces.resources.EquipmentReservationResource;

/** Transforms request/response resources and application commands.
 * @author Jose Alejandro Tello Lima
 */
public class EquipmentReservationTransform {
    public static CreateEquipmentReservationCommand toCommand(CreateEquipmentReservationResource request) {
        return new CreateEquipmentReservationCommand(request.getReservationCode(), request.getLaboratoryId(),
                request.getReservationPeriodStartDate(), request.getReservationPeriodEndDate(),
                request.getEquipmentBatchQuantity(), request.getEquipmentBatchUnit(),
                request.getAccessLevel(), request.getStatus(), request.getReservationNotes());
    }

    public static EquipmentReservationResource toResource(EquipmentReservation reservation) {
        return new EquipmentReservationResource(reservation.getId(),
                reservation.getReservationCode().code(), reservation.getLaboratoryId().value().toString(),
                reservation.getReservationPeriod().startDate(), reservation.getReservationPeriod().endDate(),
                reservation.getEquipmentBatch().quantity(), reservation.getEquipmentBatch().unit(),
                reservation.getAccessLevel(), reservation.getStatus().name(), reservation.getReservationNotes());
    }
}
