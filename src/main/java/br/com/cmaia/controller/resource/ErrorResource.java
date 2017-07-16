package br.com.cmaia.controller.resource;

public class ErrorResource {
    private final String message;

    public ErrorResource(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
