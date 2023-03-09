package com.albgott.permissionservice.permission.domain.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "permissions")
public class Permission {
    @Id
    private String name;
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PermissionType type;
    @Column(name = "owner_default")
    private boolean ownerDefault;

    protected Permission() {
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public PermissionType type() {
        return type;
    }

    public boolean isOwnerDefault() {
        return ownerDefault;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
