package com.campuslab.platform.u202421618.reservations.infrastructure.persistence.jpa.entities;

import com.campuslab.platform.u202421618.shared.infrastructure.persistence.jpa.entities.AuditableAbstractPersistenceEntity;
import jakarta.persistence.*;
import java.time.LocalDate;

/** Database representation of an equipment reservation.
 * @author Jose Alejandro Tello Lima
 */
@Entity
@Table(name = "equipment_reservations", uniqueConstraints =
@UniqueConstraint(name = "uk_equipment_reservations_reservation_code", columnNames = "reservation_code"))
public class EquipmentReservationPersistenceEntity extends AuditableAbstractPersistenceEntity {
    @Column(name = "reservation_code", nullable = false, unique = true)
    private String reservationCode;
    @Column(name = "laboratory_id", nullable = false, length = 36)
    private String laboratoryId;
    @Column(name = "reservation_period_start_date", nullable = false)
    private LocalDate reservationPeriodStartDate;
    @Column(name = "reservation_period_end_date", nullable = false)
    private LocalDate reservationPeriodEndDate;
    @Column(name = "equipment_batch_quantity", nullable = false)
    private Integer equipmentBatchQuantity;
    @Column(name = "equipment_batch_unit", nullable = false)
    private String equipmentBatchUnit;
    @Column(name = "access_level", nullable = false)
    private Integer accessLevel;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "reservation_notes")
    private String reservationNotes;

    public String getReservationCode() { return reservationCode; }
    public void setReservationCode(String value) { reservationCode = value; }
    public String getLaboratoryId() { return laboratoryId; }
    public void setLaboratoryId(String value) { laboratoryId = value; }
    public LocalDate getReservationPeriodStartDate() { return reservationPeriodStartDate; }
    public void setReservationPeriodStartDate(LocalDate value) { reservationPeriodStartDate = value; }
    public LocalDate getReservationPeriodEndDate() { return reservationPeriodEndDate; }
    public void setReservationPeriodEndDate(LocalDate value) { reservationPeriodEndDate = value; }
    public Integer getEquipmentBatchQuantity() { return equipmentBatchQuantity; }
    public void setEquipmentBatchQuantity(Integer value) { equipmentBatchQuantity = value; }
    public String getEquipmentBatchUnit() { return equipmentBatchUnit; }
    public void setEquipmentBatchUnit(String value) { equipmentBatchUnit = value; }
    public Integer getAccessLevel() { return accessLevel; }
    public void setAccessLevel(Integer value) { accessLevel = value; }
    public String getStatus() { return status; }
    public void setStatus(String value) { status = value; }
    public String getReservationNotes() { return reservationNotes; }
    public void setReservationNotes(String value) { reservationNotes = value; }
}
