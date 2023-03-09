package com.albgott.permissionservice.role.domain.model;

import com.albgott.permissionservice.permission.domain.model.Permission;
import jakarta.persistence.*;
import lombok.NonNull;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import java.util.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    private UUID id;

    @Column(name = "business_id")
    private UUID businessId;


    @Column(nullable = false)
    private String name;
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Permission> permissions = new HashSet<>();

    protected Role() {
    }

    public Role(@NonNull UUID id, UUID businessId,@NonNull String name, String description, Set<Permission> permissions) {
        Validate.notEmpty(name.trim());
        this.id = id;
        this.businessId = businessId;
        this.name = name.trim().toLowerCase();
        this.description = description == null? "" : description;
        this.permissions = new HashSet<>();
        if(permissions != null) permissions.forEach(this::addPermission);
    }

    public void addPermissions(List<Permission> permissions){
        if(permissions == null) return;
        for(Permission permission: permissions){
            addPermission(permission);
        }
    }

    public void removePermissions(List<Permission> permissions){
        if(permissions == null) return;
        for(Permission permission: permissions){
            if(permission == null) continue;
            this.permissions.remove(permission);
        }
    }

    public void modifyName(String name){
        if(name == null || StringUtils.isEmpty(name.trim())) return;
        this.name = name.trim().toLowerCase();
    }

    public void modifyDescription(String description){
        if(description == null) return;
        this.name = description.trim();
    }

    public UUID id() {
        return id;
    }

    public UUID businessId() {
        return businessId;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public Set<Permission> permissions() {
        return permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean isFromBusiness(UUID businessId){
        return this.businessId.equals(businessId);
    }

    public void addPermission(Permission permission){
        if(permission == null) return ;
        if(this.businessId == null && permission.isAdministrative()) {
            this.permissions.add(permission);
        }
        if(this.businessId != null && !permission.isAdministrative()) {
            this.permissions.add(permission);
        }
    }
}
