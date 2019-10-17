package com.stackroute.muzix.controller;


import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exception.NoTrackExistException;
import com.stackroute.muzix.exception.TrackAlreadyExistException;
import com.stackroute.muzix.exception.TrackDoesNotExistException;
import com.stackroute.muzix.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value="api/v1")
@RestController
public class TrackController {
    private TrackService trackService;
    @Autowired
    public TrackController(TrackService ts){this.trackService=ts; }

    private ResponseEntity responseEntity;


    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws NoTrackExistException {
        try {
            trackService.saveTrack(track);
        }
        catch(TrackAlreadyExistException ex) {
            responseEntity =new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
            ex.printStackTrace();
            return responseEntity;
        }
        return getAllTracks();
    }
    @GetMapping("track")
    public ResponseEntity<?> getAllTracks() throws NoTrackExistException {
        try {
            responseEntity = new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
        }
        catch(NoTrackExistException ex) {
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
            ex.printStackTrace();
        }
        return responseEntity;
    }
    @DeleteMapping("track")
    public ResponseEntity<?> deleteTrack(@RequestBody Track track) throws NoTrackExistException {
        try {
            trackService.removeTrack(track.getTrackId());
        }
        catch (TrackDoesNotExistException ex) {
            responseEntity=new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
            ex.printStackTrace();
            return responseEntity;
        }
        return getAllTracks();
    }
    @PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) throws NoTrackExistException {
        try {
            int trackId=track.getTrackId();
            String comment=track.getComment();
            trackService.updateTrack(trackId,comment);
        }
        catch(TrackDoesNotExistException ex) {
            responseEntity=new ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND);
            ex.printStackTrace();
            return responseEntity;
        }
        return getAllTracks();
    }
    @GetMapping("byName")
    public ResponseEntity<?> getAllTracksByName(@RequestParam String trackName) throws TrackDoesNotExistException {
        try {
            responseEntity = new ResponseEntity<List<Track>>(trackService.findTracksByName(trackName), HttpStatus.OK);
        }
        catch (TrackDoesNotExistException ex) {
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
            ex.printStackTrace();
        }
        return responseEntity;
    }

}
