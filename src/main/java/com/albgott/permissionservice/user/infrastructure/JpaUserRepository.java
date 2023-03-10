package com.albgott.permissionservice.user.infrastructure;

import com.albgott.permissionservice.user.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JpaUserRepository extends JpaRepository<User, UUID> {
    List<User> findByBusinessId(UUID businessId);
}
