package com.albgott.permissionservice.role.application.find;

import com.albgott.permissionservice.role.application.RoleDTO;
import com.albgott.permissionservice.role.domain.model.Role;
import com.albgott.permissionservice.role.domain.repository.RoleRepository;
import com.albgott.permissionservice.shared.application.QueryUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindRolesFromBusinessService extends QueryUseCase<FindRolesFromBusinessQuery, List<RoleDTO>> {

    private final RoleRepository roleRepository;

    public FindRolesFromBusinessService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    protected List<RoleDTO> doExec(FindRolesFromBusinessQuery command) {
        List<Role> roles = roleRepository.findRolesFromBusiness(command.businessId());
        return roles.stream().map(RoleDTO::new).toList();
    }
}
