package com.albgott.permissionservice.user.application.find;

import com.albgott.permissionservice.shared.application.QueryUseCase;
import com.albgott.permissionservice.user.application.UserDTO;
import com.albgott.permissionservice.user.domain.model.User;
import com.albgott.permissionservice.user.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindUsersFromBusinessService extends QueryUseCase<FindUsersFromBusinessQuery, List<UserDTO>> {

    private final UserRepository userRepository;

    public FindUsersFromBusinessService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    protected List<UserDTO> doExec(FindUsersFromBusinessQuery command) {
        List<User> users = userRepository.findUsersFromBusiness(command.businessId());

        return users.stream().map(UserDTO::new).toList();
    }
}
