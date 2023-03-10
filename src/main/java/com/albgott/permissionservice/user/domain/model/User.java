package com.albgott.permissionservice.user.domain.model;

import com.albgott.permissionservice.permission.domain.model.Permission;
import com.albgott.permissionservice.role.domain.model.Role;
import jakarta.persistence.*;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    private UUID id;
    @Column(name = "business_id")
    private UUID businessId;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType type;
    @ManyToMany(fetch = FetchType.EAGER)
    private HashSet<Permission> permissions = new HashSet<>();
    @ManyToMany(fetch = FetchType.EAGER)
    private HashSet<Role> roles = new HashSet<>();

    protected User() {
    }

    public User(@NonNull UUID id, UUID businessId,@NonNull UserType type) {
        this.id = id;
        this.businessId = businessId;
        this.type = type;

        if(businessId == null && type.isBusiness()){
            throw new RuntimeException("Business accounts requires business");
        }
    }

    public UUID id() {
        return id;
    }

    public UUID businessId() {
        return businessId;
    }

    public UserType type() {
        return type;
    }

    public HashSet<Permission> permissions() {
        return permissions;
    }

    public HashSet<Role> roles() {
        return roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
