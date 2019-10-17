package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exception.TrackAlreadyExistException;
import com.stackroute.muzix.exception.TrackDoesNotExistException;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository t){this.trackRepository=t; }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistException {
        if(trackRepository.existsById(track.getTrackId())) {
            throw new TrackAlreadyExistException("Track Already Exist");
        }
        Track savedTrack=trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public void update(int updateId, String s) throws TrackDoesNotExistException{
        if(!trackRepository.existsById(updateId)) {
            throw new TrackDoesNotExistException("Track is not in the saved list");
        }
        Track track = trackRepository.getOne(updateId);
        Track updatedTrack=new Track();
        updatedTrack.setTrackId(updateId);
        updatedTrack.setTrackName(track.getTrackName());
        updatedTrack.setComment(s);
        trackRepository.deleteById(updateId);
        trackRepository.save(updatedTrack);
    }

    @Override
    public void remove(int deleteId) throws TrackDoesNotExistException{
        if(!trackRepository.existsById(deleteId))
        {
            throw new TrackDoesNotExistException("Track not found");
        }
        trackRepository.deleteById(deleteId);
    }
}
