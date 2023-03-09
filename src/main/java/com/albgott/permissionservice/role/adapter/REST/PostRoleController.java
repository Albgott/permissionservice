package com.albgott.permissionservice.role.adapter.REST;

import com.albgott.permissionservice.role.application.create.CreateRoleCommand;
import com.albgott.permissionservice.role.application.create.CreateRoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class PostRoleController {
    private final CreateRoleService service;

    public PostRoleController(CreateRoleService service) {
        this.service = service;
    }

    @PostMapping("/roles")
    public ResponseEntity<String> doPost(@RequestBody Body body){
        List<String> permissions = body.permissions_names == null? new ArrayList<>() : body.permissions_names;
        UUID businessId = body.business_id == null? null : UUID.fromString(body.business_id);
        service.exec(new CreateRoleCommand(
                UUID.fromString(body.id),
                body.name,
                body.description,
                UUID.fromString(body.id),
                permissions
        ));
        return ResponseEntity.ok().build();
    }

    private record Body(String id,String name, String description , String business_id,
                        List<String> permissions_names){}
}
