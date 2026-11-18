package com.campuslab.platform.u202421618.reservations.domain.model.aggregates;

import com.campuslab.platform.u202421618.reservations.domain.model.valueobjects.*;
import java.time.Instant;


public class EquipmentReservation {
    private final Long id;
    private final ReservationCode reservationCode;
    private final LaboratoryId laboratoryId;
    private final ReservationPeriod reservationPeriod;
    private final EquipmentBatch equipmentBatch;
    private final Integer accessLevel;
    private final ReservationStatus status;
    private final String reservationNotes;
    private final Instant createdAt;
    private final Instant updatedAt;

    public EquipmentReservation(Long id, ReservationCode reservationCode,
                                LaboratoryId laboratoryId, ReservationPeriod reservationPeriod,
                                EquipmentBatch equipmentBatch, Integer accessLevel,
                                ReservationStatus status, String reservationNotes,
                                Instant createdAt, Instant updatedAt) {
        if (reservationCode == null || laboratoryId == null || reservationPeriod == null || equipmentBatch == null) {
            throw new IllegalArgumentException("Reservation fields are required.");
        }
        if (accessLevel == null || accessLevel < 1 || accessLevel > 5) {
            throw new IllegalArgumentException("Access level must be between 1 and 5.");
        }
        this.id = id;
        this.reservationCode = reservationCode;
        this.laboratoryId = laboratoryId;
        this.reservationPeriod = reservationPeriod;
        this.equipmentBatch = equipmentBatch;
        this.accessLevel = accessLevel;
        this.status = status == null ? ReservationStatus.PENDING : status;
        this.reservationNotes = reservationNotes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() { return id; }
    public ReservationCode getReservationCode() { return reservationCode; }
    public LaboratoryId getLaboratoryId() { return laboratoryId; }
    public ReservationPeriod getReservationPeriod() { return reservationPeriod; }
    public EquipmentBatch getEquipmentBatch() { return equipmentBatch; }
    public Integer getAccessLevel() { return accessLevel; }
    public ReservationStatus getStatus() { return status; }
    public String getReservationNotes() { return reservationNotes; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
}
