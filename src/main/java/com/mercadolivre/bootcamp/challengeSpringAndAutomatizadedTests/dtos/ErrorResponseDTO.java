package com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.dtos;

public class ErrorResponseDTO {
    private String message;
    private String cause;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
