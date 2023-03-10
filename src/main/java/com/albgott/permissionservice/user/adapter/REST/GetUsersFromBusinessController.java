package com.albgott.permissionservice.user.adapter.REST;

import com.albgott.permissionservice.user.application.UserDTO;
import com.albgott.permissionservice.user.application.find.FindUsersFromBusinessQuery;
import com.albgott.permissionservice.user.application.find.FindUsersFromBusinessService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class GetUsersFromBusinessController {
    private final FindUsersFromBusinessService service;

    public GetUsersFromBusinessController(FindUsersFromBusinessService service) {
        this.service = service;
    }

    @GetMapping("/users/business/{id}")
    public ResponseEntity<List<UserDTO>> doGet(@PathVariable(name = "id") String businessId){
        List<UserDTO> userDTOS = service.exec(new FindUsersFromBusinessQuery(UUID.fromString(businessId)));
        return ResponseEntity.ok(userDTOS);
    }
}
