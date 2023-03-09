package com.albgott.permissionservice.permission.infrastructure;

import com.albgott.permissionservice.permission.domain.model.Permission;
import com.albgott.permissionservice.permission.domain.model.PermissionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaPermissionRepository extends JpaRepository<Permission, String> {
    List<Permission> findByType(PermissionType type);
    List<Permission> findByOwnerDefaultTrue();
}
