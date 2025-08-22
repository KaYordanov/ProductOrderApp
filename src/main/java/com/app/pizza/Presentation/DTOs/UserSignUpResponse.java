package com.app.pizza.Presentation.DTOs;

public class UserSignUpResponse {
    private boolean successful;
    private String message;

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
