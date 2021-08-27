package com.github.mperry.rest;

public class AuthResponse {

    String message;
    int status;
    String error;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public AuthResponse(String message, int status, String error) {
        this.message = message;
        this.status = status;
        this.error = error;
    }
}
