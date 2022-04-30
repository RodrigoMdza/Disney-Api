package com.disney.exception;

public enum ErrorsEnum {
    
    IDMOVIENOTFOUND("This movieId is not present"),
    IDCHARACTERNOTFOUND("This characerId is not present"),
    PARAMNOTFOUND("A request param is not present"),
    USERNOTFOUND("Incorresct User o Password");

    private String message;

    private ErrorsEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
}
