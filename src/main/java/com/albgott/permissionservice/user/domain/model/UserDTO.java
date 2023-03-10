package com.albgott.permissionservice.user.domain.model;

import com.albgott.permissionservice.permission.application.PermissionDTO;
import com.albgott.permissionservice.role.application.RoleDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class UserDTO {
    private String id;
    private String businessId;
    private Set<RoleDTO> roles;
    private Set<PermissionDTO> permissions;

    public UserDTO(User user) {
        this.id = user.id().toString();
        this.businessId = user.businessId().toString();
        this.roles = user.roles().stream().map(RoleDTO::new).collect(Collectors.toSet());
        this.permissions = user.permissions().stream().map(PermissionDTO::new).collect(Collectors.toSet());
    }
}
