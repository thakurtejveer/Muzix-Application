package com.stackroute.muzix.controlleradvice;


import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exception.NoTrackExistException;
import com.stackroute.muzix.exception.TrackAlreadyExistException;
import com.stackroute.muzix.exception.TrackDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {
    @ResponseBody
    @ExceptionHandler(TrackAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String trackExistAdvice(TrackAlreadyExistException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(TrackDoesNotExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String trackExistAdvice(TrackDoesNotExistException ex) {
        return ex.getMessage();
    }
    @ResponseBody
    @ExceptionHandler(NoTrackExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String trackExistAdvice(NoTrackExistException ex) {
        return ex.getMessage();
    }


}
