package com.albgott.permissionservice.user.infrastructure;

import com.albgott.permissionservice.user.domain.model.User;
import com.albgott.permissionservice.user.domain.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final JpaUserRepository repository;

    public UserRepositoryImpl(JpaUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<User> findUsersFromBusiness(UUID id) {
        return repository.findByBusinessId(id);
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    @Override
    public void delete(UUID uuid) {
        repository.deleteById(uuid);
    }
}
