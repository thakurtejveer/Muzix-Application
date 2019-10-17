package com.stackroute.muzix.exception;

public class NoTrackExistException extends Exception {
    private String message;

    public NoTrackExistException() {}

    public NoTrackExistException(String message) {
        super(message);
        this.message = message;
    }
}
