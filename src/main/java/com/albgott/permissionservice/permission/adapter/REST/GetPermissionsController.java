package com.albgott.permissionservice.permission.adapter.REST;

import com.albgott.permissionservice.permission.application.PermissionDTO;
import com.albgott.permissionservice.permission.application.find.FindPermissionsQuery;
import com.albgott.permissionservice.permission.application.find.FindPermissionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetPermissionsController {
    private final FindPermissionsService service;

    public GetPermissionsController(FindPermissionsService service) {
        this.service = service;
    }

    @GetMapping("/permissions")
    public ResponseEntity<List<PermissionDTO>> doGet(@RequestParam String type){
        List<PermissionDTO> permissionDTOS = service.exec(new FindPermissionsQuery(type));
        return ResponseEntity.ok(permissionDTOS);
    }
}
