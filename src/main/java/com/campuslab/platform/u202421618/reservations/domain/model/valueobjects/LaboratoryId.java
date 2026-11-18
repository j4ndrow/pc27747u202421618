package com.campuslab.platform.u202421618.reservations.domain.model.valueobjects;

import java.util.UUID;

public record LaboratoryId(UUID value) {
    public LaboratoryId {
        if (value == null) throw new IllegalArgumentException("Laboratory ID is required.");
    }
}
