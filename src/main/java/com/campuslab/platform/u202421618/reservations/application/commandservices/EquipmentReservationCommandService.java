package com.campuslab.platform.u202421618.reservations.application.commandservices;

import com.campuslab.platform.u202421618.reservations.application.commands.CreateEquipmentReservationCommand;
import com.campuslab.platform.u202421618.reservations.domain.model.EquipmentReservation;
import com.campuslab.platform.u202421618.shared.application.Result;

/** Contract for creating equipment reservations. @author Jose Alejandro Tello Lima */
public interface EquipmentReservationCommandService {
    Result<EquipmentReservation> handle(CreateEquipmentReservationCommand command);
}
