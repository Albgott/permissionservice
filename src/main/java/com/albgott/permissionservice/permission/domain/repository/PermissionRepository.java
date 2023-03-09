package com.albgott.permissionservice.permission.domain.repository;

import com.albgott.permissionservice.permission.domain.model.Permission;
import com.albgott.permissionservice.permission.domain.model.PermissionType;

import java.util.List;
import java.util.Optional;

public interface PermissionRepository {
    List<Permission> findPermissionsByType(PermissionType type);
    List<Permission> findDefaultOwnerPermissions();
    Optional<Permission> findByName(String name);
}
