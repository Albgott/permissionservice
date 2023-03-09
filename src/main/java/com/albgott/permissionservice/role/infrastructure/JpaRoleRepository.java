package com.albgott.permissionservice.role.infrastructure;

import com.albgott.permissionservice.role.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JpaRoleRepository extends JpaRepository<Role, UUID> {
    boolean existsByNameIgnoreCaseAndBusinessId(String name, UUID businessId);
    List<Role> findByBusinessId(UUID businessId);
}
