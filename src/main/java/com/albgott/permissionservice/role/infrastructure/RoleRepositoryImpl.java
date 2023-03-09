package com.albgott.permissionservice.role.infrastructure;

import com.albgott.permissionservice.role.domain.model.Role;
import com.albgott.permissionservice.role.domain.repository.RoleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    private final JpaRoleRepository repository;

    public RoleRepositoryImpl(JpaRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isNameUsedOnBusiness(String name, UUID businessId) {
        return repository.existsByNameIgnoreCaseAndBusinessId(name, businessId);
    }

    @Override
    public List<Role> findRolesFromBusiness(UUID businessId) {
        return repository.findByBusinessId(businessId);
    }

    @Override
    public void save(Role role) {
        repository.save(role);
    }

    @Override
    public void delete(Role role) {
        repository.delete(role);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
