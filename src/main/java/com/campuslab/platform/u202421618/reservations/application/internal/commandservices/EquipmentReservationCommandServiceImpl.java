package com.campuslab.platform.u202421618.reservations.application.internal.commandservices;

import com.campuslab.platform.u202421618.reservations.application.commandservices.EquipmentReservationCommandService;
import com.campuslab.platform.u202421618.reservations.application.commands.CreateEquipmentReservationCommand;
import com.campuslab.platform.u202421618.reservations.domain.exceptions.DuplicateReservationCodeException;
import com.campuslab.platform.u202421618.reservations.domain.model.aggregates.EquipmentReservation;
import com.campuslab.platform.u202421618.reservations.domain.model.valueobjects.*;
import com.campuslab.platform.u202421618.reservations.domain.repositories.EquipmentReservationRepository;
import com.campuslab.platform.u202421618.shared.application.Result;
import org.springframework.stereotype.Service;
import java.util.UUID;

/** Creates and validates equipment reservations.
 * @author Jose Alejandro Tello Lima
 */
@Service
public class EquipmentReservationCommandServiceImpl implements EquipmentReservationCommandService {
    private final EquipmentReservationRepository repository;

    public EquipmentReservationCommandServiceImpl(EquipmentReservationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Result<EquipmentReservation> handle(CreateEquipmentReservationCommand command) {
        try {
            ReservationCode code = new ReservationCode(command.reservationCode());
            LaboratoryId lab = new LaboratoryId(UUID.fromString(command.laboratoryId()));
            ReservationPeriod period = new ReservationPeriod(
                    command.reservationPeriodStartDate(), command.reservationPeriodEndDate());
            EquipmentBatch batch = new EquipmentBatch(
                    command.equipmentBatchQuantity(), command.equipmentBatchUnit());
            ReservationStatus status = ReservationStatus.valueOf(command.status());

            EquipmentReservation reservation = new EquipmentReservation(null, code, lab,
                    period, batch, command.accessLevel(), status,
                    command.reservationNotes(), null, null);

            if (repository.existsByReservationCode(code.code())) {
                return new Result.Failure<>("duplicate");
            }
            return new Result.Success<>(repository.save(reservation));
        } catch (DuplicateReservationCodeException error) {
            return new Result.Failure<>("duplicate");
        } catch (IllegalArgumentException | NullPointerException error) {
            return new Result.Failure<>("invalid");
        } catch (RuntimeException error) {
            return new Result.Failure<>("internal");
        }
    }
}
