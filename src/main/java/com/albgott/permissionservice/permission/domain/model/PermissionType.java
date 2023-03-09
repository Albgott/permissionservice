package com.albgott.permissionservice.permission.domain.model;

public enum PermissionType {
    ADMINISTRATIVE, BUSINESS;

    public boolean isAdministrative() {
        return this.equals(PermissionType.ADMINISTRATIVE);
    }
}
