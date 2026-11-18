package com.campuslab.platform.u202421618.reservations.interfaces.controllers;

import com.campuslab.platform.u202421618.reservations.application.commandservices.EquipmentReservationCommandService;
import com.campuslab.platform.u202421618.reservations.domain.model.aggregates.EquipmentReservation;
import com.campuslab.platform.u202421618.reservations.interfaces.resources.*;
import com.campuslab.platform.u202421618.reservations.interfaces.transforms.EquipmentReservationTransform;
import com.campuslab.platform.u202421618.shared.application.Result;
import com.campuslab.platform.u202421618.shared.interfaces.rest.ErrorResource;
import com.campuslab.platform.u202421618.shared.interfaces.rest.MessageTranslator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Locale;

/** Exposes the equipment reservation creation endpoint.
 * @author Jose Alejandro Tello Lima
 */
@RestController
@RequestMapping("/api/v1/equipment-reservations")
@Tag(name = "Equipment Reservations", description = "Operations for reserving laboratory equipment")
public class EquipmentReservationController {
    private final EquipmentReservationCommandService service;
    private final MessageTranslator translator;

    public EquipmentReservationController(EquipmentReservationCommandService service, MessageTranslator translator) {
        this.service = service;
        this.translator = translator;
    }

    @PostMapping
    @Operation(summary = "Create an equipment reservation")
    public ResponseEntity<?> create(@Valid @RequestBody CreateEquipmentReservationResource request, Locale locale) {
        Result<EquipmentReservation> result = service.handle(EquipmentReservationTransform.toCommand(request));
        if (result instanceof Result.Success<EquipmentReservation> success) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(EquipmentReservationTransform.toResource(success.value()));
        }
        Result.Failure<?> failure = (Result.Failure<?>) result;
        HttpStatus httpStatus = switch (failure.errorCode()) {
            case "duplicate" -> HttpStatus.CONFLICT;
            case "invalid" -> HttpStatus.BAD_REQUEST;
            default -> HttpStatus.INTERNAL_SERVER_ERROR;
        };
        return ResponseEntity.status(httpStatus)
                .body(new ErrorResource(translator.get(failure.errorCode(), locale)));
    }
}
