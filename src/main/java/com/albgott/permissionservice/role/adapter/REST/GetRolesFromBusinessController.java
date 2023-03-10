package com.albgott.permissionservice.role.adapter.REST;

import com.albgott.permissionservice.role.application.RoleDTO;
import com.albgott.permissionservice.role.application.find.FindRolesFromBusinessQuery;
import com.albgott.permissionservice.role.application.find.FindRolesFromBusinessService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class GetRolesFromBusinessController {
    private final FindRolesFromBusinessService service;

    public GetRolesFromBusinessController(FindRolesFromBusinessService service) {
        this.service = service;
    }

    @GetMapping("/roles/business/{id}")
    public ResponseEntity<List<RoleDTO>> doGet(@PathVariable String id){
        List<RoleDTO> roles = service.exec(new FindRolesFromBusinessQuery(UUID.fromString(id)));
        return ResponseEntity.ok(roles);
    }
}
