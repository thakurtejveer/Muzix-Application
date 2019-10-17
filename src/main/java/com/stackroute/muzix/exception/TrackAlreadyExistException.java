package com.stackroute.muzix.exception;

public class TrackAlreadyExistException extends Exception{
    private String message;

    public TrackAlreadyExistException() {
    }

    public TrackAlreadyExistException(String s) {
        super(s);
        this.message = s;
    }
}
