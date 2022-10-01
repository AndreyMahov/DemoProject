package com.prideTeam.AstonWebSchool.exception;

public class EntityInTransientStateException extends RuntimeException{
    private final String msgCode;

    public EntityInTransientStateException(String msgCode) {
        this.msgCode = msgCode;
    }
}
