package com.campuslab.platform.u202421618.reservations.infrastructure.persistence.jpa.adapters;

import com.campuslab.platform.u202421618.reservations.domain.exceptions.DuplicateReservationCodeException;
import com.campuslab.platform.u202421618.reservations.domain.model.aggregates.EquipmentReservation;
import com.campuslab.platform.u202421618.reservations.domain.repositories.EquipmentReservationRepository;
import com.campuslab.platform.u202421618.reservations.infrastructure.persistence.jpa.mappers.EquipmentReservationPersistenceMapper;
import com.campuslab.platform.u202421618.reservations.infrastructure.persistence.jpa.repositories.EquipmentReservationJpaRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

/** Implements the domain repository using Spring Data JPA.
 * @author Jose Alejandro Tello Lima
 */
@Repository
public class EquipmentReservationPersistenceAdapter implements EquipmentReservationRepository {
    private final EquipmentReservationJpaRepository jpaRepository;
    private final EquipmentReservationPersistenceMapper mapper;

    public EquipmentReservationPersistenceAdapter(EquipmentReservationJpaRepository jpaRepository,
                                                  EquipmentReservationPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public boolean existsByReservationCode(String code) {
        return jpaRepository.existsByReservationCode(code);
    }

    @Override
    public EquipmentReservation save(EquipmentReservation reservation) {
        try {
            return mapper.toDomain(jpaRepository.saveAndFlush(mapper.toEntity(reservation)));
        } catch (DataIntegrityViolationException error) {
            throw new DuplicateReservationCodeException();
        }
    }
}
