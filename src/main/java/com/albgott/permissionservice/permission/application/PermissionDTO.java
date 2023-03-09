package com.albgott.permissionservice.permission.application;

import com.albgott.permissionservice.permission.domain.model.Permission;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PermissionDTO {
    private String name;
    private String description;

    public PermissionDTO(Permission permission) {
        this.name = permission.name();
        this.description = permission.description();
    }
}
