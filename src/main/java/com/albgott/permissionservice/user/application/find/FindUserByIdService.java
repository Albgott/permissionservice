package com.albgott.permissionservice.user.application.find;

import com.albgott.permissionservice.shared.application.QueryUseCase;
import com.albgott.permissionservice.user.application.UserDTO;
import com.albgott.permissionservice.user.domain.model.User;
import com.albgott.permissionservice.user.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class FindUserByIdService extends QueryUseCase<FindUserByIdQuery, UserDTO> {

    private final UserRepository repository;

    public FindUserByIdService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    protected UserDTO doExec(FindUserByIdQuery command) {
        User user = repository.findById(command.id())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new UserDTO(user);
    }
}
