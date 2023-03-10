package com.albgott.permissionservice.user.application;

import com.albgott.permissionservice.permission.application.PermissionDTO;
import com.albgott.permissionservice.role.application.RoleDTO;
import com.albgott.permissionservice.user.domain.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class UserDTO {
    private String id;
    private String businessId;
    private List<String> roles_names;
    private List<String> permissions_names;

    public UserDTO(User user) {
        this.id = user.id().toString();
        this.businessId = user.businessId().toString();
        this.roles_names = user.rolesNames();
        this.permissions_names = user.permissionsNames();
    }
}
