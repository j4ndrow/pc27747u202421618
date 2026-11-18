package com.campuslab.platform.u202421618.reservations.domain.repositories;

import com.campuslab.platform.u202421618.reservations.domain.model.aggregates.EquipmentReservation;

public interface EquipmentReservationRepository {
    boolean existsByReservationCode(String code);
    EquipmentReservation save(EquipmentReservation reservation);
}
