package com.albgott.permissionservice.role.domain.repository;

import com.albgott.permissionservice.role.domain.model.Role;

import java.util.List;
import java.util.UUID;

public interface RoleRepository {
    boolean isNameUsedOnBusiness(String name, UUID businessId);
    List<Role> findRolesFromBusiness(UUID businessId);
    void save(Role role);
    void delete(Role role);
    void delete(UUID id);
}
