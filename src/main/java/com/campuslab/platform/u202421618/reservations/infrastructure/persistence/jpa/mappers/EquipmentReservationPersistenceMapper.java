package com.campuslab.platform.u202421618.reservations.infrastructure.persistence.jpa.mappers;

import com.campuslab.platform.u202421618.reservations.domain.model.aggregates.EquipmentReservation;
import com.campuslab.platform.u202421618.reservations.domain.model.valueobjects.*;
import com.campuslab.platform.u202421618.reservations.infrastructure.persistence.jpa.entities.EquipmentReservationPersistenceEntity;
import org.springframework.stereotype.Component;
import java.util.UUID;

/** Maps a domain reservation to its JPA entity and back.
 * @author Jose Alejandro Tello Lima
 */
@Component
public class EquipmentReservationPersistenceMapper {
    public EquipmentReservationPersistenceEntity toEntity(EquipmentReservation reservation) {
        EquipmentReservationPersistenceEntity entity = new EquipmentReservationPersistenceEntity();
        entity.setReservationCode(reservation.getReservationCode().code());
        entity.setLaboratoryId(reservation.getLaboratoryId().value().toString());
        entity.setReservationPeriodStartDate(reservation.getReservationPeriod().startDate());
        entity.setReservationPeriodEndDate(reservation.getReservationPeriod().endDate());
        entity.setEquipmentBatchQuantity(reservation.getEquipmentBatch().quantity());
        entity.setEquipmentBatchUnit(reservation.getEquipmentBatch().unit());
        entity.setAccessLevel(reservation.getAccessLevel());
        entity.setStatus(reservation.getStatus().name());
        entity.setReservationNotes(reservation.getReservationNotes());
        return entity;
    }

    public EquipmentReservation toDomain(EquipmentReservationPersistenceEntity entity) {
        return new EquipmentReservation(entity.getId(),
                new ReservationCode(entity.getReservationCode()),
                new LaboratoryId(UUID.fromString(entity.getLaboratoryId())),
                new ReservationPeriod(entity.getReservationPeriodStartDate(), entity.getReservationPeriodEndDate()),
                new EquipmentBatch(entity.getEquipmentBatchQuantity(), entity.getEquipmentBatchUnit()),
                entity.getAccessLevel(), ReservationStatus.valueOf(entity.getStatus()),
                entity.getReservationNotes(), entity.getCreatedAt(), entity.getUpdatedAt());
    }
}
