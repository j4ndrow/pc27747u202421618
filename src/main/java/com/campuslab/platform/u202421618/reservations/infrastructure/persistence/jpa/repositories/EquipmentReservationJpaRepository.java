package com.campuslab.platform.u202421618.reservations.infrastructure.persistence.jpa.repositories;

import com.campuslab.platform.u202421618.reservations.infrastructure.persistence.jpa.entities.EquipmentReservationPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/** Spring Data repository for stored reservations.
 * @author Jose Alejandro Tello Lima
 */
public interface EquipmentReservationJpaRepository extends JpaRepository<EquipmentReservationPersistenceEntity, Long> {
    boolean existsByReservationCode(String reservationCode);
}
