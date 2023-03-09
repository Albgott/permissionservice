package com.albgott.permissionservice.permission.infrastructure;

import com.albgott.permissionservice.permission.domain.model.Permission;
import com.albgott.permissionservice.permission.domain.model.PermissionType;
import com.albgott.permissionservice.permission.domain.repository.PermissionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PermissionRepositoryImpl implements PermissionRepository {
    private final JpaPermissionRepository repository;

    public PermissionRepositoryImpl(JpaPermissionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Permission> findPermissionsByType(PermissionType type) {
        return repository.findByType(type);
    }

    @Override
    public List<Permission> findDefaultOwnerPermissions() {
        return repository.findByOwnerDefaultTrue();
    }

    @Override
    public Optional<Permission> findByName(String name) {
        return repository.findByNameIgnoreCase(name);
    }
}
