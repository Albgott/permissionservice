package com.albgott.permissionservice.role.application;

import com.albgott.permissionservice.permission.application.PermissionDTO;
import com.albgott.permissionservice.role.domain.model.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class RoleDTO {
    private String id;
    private String businessId;
    private String name;
    private String description;
    private List<PermissionDTO> permissions;

    public RoleDTO(Role role) {
        this.id = role.id().toString();
        this.businessId = role.businessId().toString();
        this.name = role.name();
        this.description = role.description();
        this.permissions = role.permissions().stream().map(PermissionDTO::new).toList();
    }
}
