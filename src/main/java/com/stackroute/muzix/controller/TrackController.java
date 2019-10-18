package com.stackroute.muzix.controller;


import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exception.NoTrackExistException;
import com.stackroute.muzix.exception.TrackAlreadyExistException;
import com.stackroute.muzix.exception.TrackDoesNotExistException;
import com.stackroute.muzix.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value="api/v1")
@RestController
public class TrackController {
    private TrackService trackService;
   @Autowired
    public TrackController( TrackService trackService){
//       System.out.println("in track controller");    //used this line to know the internal functioning
       this.trackService=trackService;
   }
    public TrackController(){}

    private ResponseEntity responseEntity;


    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws NoTrackExistException, TrackAlreadyExistException{
            trackService.saveTrack(track);
        return getAllTracks();
    }
    @GetMapping("track")
    public ResponseEntity<?> getAllTracks() throws NoTrackExistException {
            responseEntity = new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("track")
    public ResponseEntity<?> deleteTrack(@RequestBody Track track) throws TrackDoesNotExistException,NoTrackExistException {
            trackService.removeTrack(track.getTrackId());
        return getAllTracks();
    }
    @PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) throws NoTrackExistException, TrackDoesNotExistException{
            int trackId=track.getTrackId();
            String comment=track.getComment();
            trackService.updateTrack(trackId,comment);
        return getAllTracks();
    }
    @GetMapping("byName")
    public ResponseEntity<?> getAllTracksByName(@RequestParam String trackName) throws NoTrackExistException {
            responseEntity = new ResponseEntity<List<Track>>(trackService.findTracksByName(trackName), HttpStatus.OK);
        return responseEntity;
    }

}
