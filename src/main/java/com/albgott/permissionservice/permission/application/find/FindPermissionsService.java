package com.albgott.permissionservice.permission.application.find;

import com.albgott.permissionservice.permission.application.PermissionDTO;
import com.albgott.permissionservice.permission.domain.model.Permission;
import com.albgott.permissionservice.permission.domain.model.PermissionType;
import com.albgott.permissionservice.permission.domain.repository.PermissionRepository;
import com.albgott.permissionservice.shared.application.QueryUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindPermissionsService extends QueryUseCase<FindPermissionsQuery, List<PermissionDTO>> {

    private final PermissionRepository repository;

    public FindPermissionsService(PermissionRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    protected List<PermissionDTO> doExec(FindPermissionsQuery command) {

        PermissionType type;
        try{
            type = PermissionType.valueOf(command.type().toUpperCase());
        }catch (IllegalArgumentException e){ throw new RuntimeException("Permission type not found");}

        List<Permission> permissions = repository.findPermissionsByType(type);

        return permissions.stream().map(PermissionDTO::new).toList();
    }
}
