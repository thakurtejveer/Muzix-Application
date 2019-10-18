package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exception.NoTrackExistException;
import com.stackroute.muzix.exception.TrackAlreadyExistException;
import com.stackroute.muzix.exception.TrackDoesNotExistException;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public interface TrackService {
     Track saveTrack(Track track) throws TrackAlreadyExistException;
     List<Track> getAllTracks() throws NoTrackExistException;
     Track updateTrack(int updateId, String comment) throws TrackDoesNotExistException;
     Track removeTrack(int deleteId) throws TrackDoesNotExistException;
     List<Track> findTracksByName(String nameTrack) throws NoTrackExistException;
}
