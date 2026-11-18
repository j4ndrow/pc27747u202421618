package com.campuslab.platform.u202421618.reservations.interfaces.resources;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

/** Body of POST /api/v1/equipment-reservations.
 * @author Jose Alejandro Tello Lima
 */
public class CreateEquipmentReservationResource {
    @NotBlank private String reservationCode;
    @NotBlank private String laboratoryId;
    @NotNull private LocalDate reservationPeriodStartDate;
    @NotNull private LocalDate reservationPeriodEndDate;
    @NotNull private Integer equipmentBatchQuantity;
    @NotBlank private String equipmentBatchUnit;
    @NotNull private Integer accessLevel;
    // Missing status stays PENDING; explicitly supplied null becomes null and is rejected.
    @NotNull private String status = "PENDING";
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
