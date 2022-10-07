package com.prideTeam.AstonWebSchool.enums;

public enum Response {

    SUCCESS("SUCCESS");

    private final String value;

    Response(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
