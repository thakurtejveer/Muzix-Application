package com.stackroute.muzix.controller;


import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exception.TrackAlreadyExistException;
import com.stackroute.muzix.exception.TrackDoesNotExistException;
import com.stackroute.muzix.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1")
@RestController
public class TrackController {
    private TrackService trackService;
    @Autowired
    public TrackController(TrackService ts){this.trackService=ts; }

    @PostMapping("track")
    public ResponseEntity<?> st(@RequestBody Track t) {
        try {
            trackService.saveTrack(t);
        }
        catch(TrackAlreadyExistException ex) {
            ResponseEntity responseEntity =new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
            ex.printStackTrace();
            return responseEntity;
        }
//        ResponseEntity responseEntity=new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
        return gt();
//        return responseEntity;
    }
    @GetMapping("track")
    public ResponseEntity<?> gt() {
        ResponseEntity responseEntity=new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("track")
    public ResponseEntity<?> dt(@RequestBody Track t) {
        try {
            trackService.remove(t.getTrackId());
        }
        catch (TrackDoesNotExistException ex) {
            ResponseEntity responseEntity=new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
            ex.printStackTrace();
            return responseEntity;
        }
        return gt();
    }
    @PutMapping("track")
    public ResponseEntity<?> ut(@RequestBody Track t) {
        try {
            int n=t.getTrackId();
            String comment=t.getComment();
            trackService.update(n,comment);
        }
        catch(TrackDoesNotExistException ex) {
            ResponseEntity responseEntity=new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
            ex.printStackTrace();
            return responseEntity;
        }
        return gt();
    }
    @GetMapping("/byName")
    public ResponseEntity<?> tbn(@RequestParam String trackName) {
        ResponseEntity responseEntity=new ResponseEntity(trackService.findTrackByName(trackName), HttpStatus.OK);
        return responseEntity;
    }

}
