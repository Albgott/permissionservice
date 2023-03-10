package com.albgott.permissionservice.user.application.find;

import lombok.NonNull;

import java.util.UUID;

public record FindUserByIdQuery(@NonNull UUID id) {
}
