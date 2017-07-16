package br.com.cmaia.domain.validator;

public class Reason {

    private String message;

    public Reason(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static Reason error(String message) {
        return new Reason(message);
    }
}