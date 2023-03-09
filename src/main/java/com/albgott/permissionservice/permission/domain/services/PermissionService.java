package com.albgott.permissionservice.permission.domain.services;

import com.albgott.permissionservice.permission.domain.model.Permission;
import com.albgott.permissionservice.permission.domain.repository.PermissionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PermissionService {
    private final PermissionRepository repository;

    public PermissionService(PermissionRepository repository) {
        this.repository = repository;
    }

    public List<Permission> getPermissionsFromNames(List<String> names){
        if(names == null) return new ArrayList<>();
        return names.stream()
                .map(name -> repository.findByName(name).orElse(null))
                .toList();
    }
}
