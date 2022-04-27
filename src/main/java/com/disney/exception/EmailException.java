package com.disney.exception;

import java.io.IOException;

public class EmailException extends IOException{
    
    public EmailException(String message) {
        super(message);
    }

}
