package com.campuslab.platform.u202421618.shared.infrastructure.persistence.jpa.entities;

import jakarta.persistence.*;
import java.time.Instant;

/**
 * @author Jose Alejandro Tello Lima
 */
@MappedSuperclass
public abstract class AuditableAbstractPersistenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @PrePersist
    protected void beforeInsert() {
        Instant now = Instant.now();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    protected void beforeUpdate() { updatedAt = Instant.now(); }

    public Long getId() { return id; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
}
