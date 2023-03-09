package com.albgott.permissionservice.role.application.create;

import com.albgott.permissionservice.permission.domain.model.Permission;
import com.albgott.permissionservice.permission.domain.services.PermissionService;
import com.albgott.permissionservice.role.domain.model.Role;
import com.albgott.permissionservice.role.domain.repository.RoleRepository;
import com.albgott.permissionservice.shared.application.CommandUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class CreateRoleService extends CommandUseCase<CreateRoleCommand> {

    private final RoleRepository roleRepository;
    private final PermissionService permissionService;

    public CreateRoleService(RoleRepository roleRepository, PermissionService permissionService) {
        this.roleRepository = roleRepository;
        this.permissionService = permissionService;
    }

    @Transactional
    @Override
    protected void doExec(CreateRoleCommand command) throws IOException {
        Role role = getRoleFromCommand(command);
        if(roleRepository.isNameUsedOnBusiness(role.name(),role.businessId()))
            throw new RuntimeException("Role name already used on business");

        roleRepository.save(role);
    }

    private Role getRoleFromCommand(CreateRoleCommand command) {
        Set<Permission> permissions =
                new HashSet<>(permissionService.getPermissionsFromNames(command.permissionsNames()));

        return new Role(
                command.id(),
                command.businessId(),
                command.name(),
                command.description(),
                permissions
        );
    }
}
