package com.albgott.permissionservice.user.adapter.REST;

import com.albgott.permissionservice.user.application.UserDTO;
import com.albgott.permissionservice.user.application.find.FindUserByIdQuery;
import com.albgott.permissionservice.user.application.find.FindUserByIdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class GetUserController {
    private final FindUserByIdService service;

    public GetUserController(FindUserByIdService service) {
        this.service = service;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> doGet(@PathVariable String id){
        UserDTO user = service.exec(new FindUserByIdQuery(UUID.fromString(id)));

        return ResponseEntity.ok(user);
    }
}
