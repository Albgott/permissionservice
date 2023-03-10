package com.albgott.permissionservice.user.domain.repository;

import com.albgott.permissionservice.user.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User> findById(UUID id);
    List<User> findUsersFromBusiness(UUID id);
    void save(User user);
    void delete(User user);
    void delete(UUID uuid);
}
