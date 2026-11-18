package com.campuslab.platform.u202421618.reservations.application.commandservices;

import com.campuslab.platform.u202421618.reservations.application.commands.CreateEquipmentReservationCommand;
import com.campuslab.platform.u202421618.reservations.domain.model.aggregates.EquipmentReservation;
import com.campuslab.platform.u202421618.shared.application.Result;

public interface EquipmentReservationCommandService {
    Result<EquipmentReservation> handle(CreateEquipmentReservationCommand command);
}
