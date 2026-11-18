package com.campuslab.platform.u202421618.reservations.domain.model.valueobjects;

public record EquipmentBatch(Integer quantity, String unit) {
    public EquipmentBatch {
        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("Equipment quantity must be greater than zero.");
        }
        if (unit == null || unit.isBlank()) {
            throw new IllegalArgumentException("Equipment unit must not be blank.");
        }
    }

    /** Returns a new batch with more equipment without changing the original.
     * @param additionalQuantity number of additional units
     * @return a new batch with the same unit
     */
    public EquipmentBatch addUnits(Integer additionalQuantity) {
        if (additionalQuantity == null || additionalQuantity <= 0) {
            throw new IllegalArgumentException("Additional quantity must be positive.");
        }
        long total = (long) quantity + additionalQuantity;
        if (total > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Equipment quantity exceeds the maximum integer.");
        }
        return new EquipmentBatch((int) total, unit);
    }
}
