package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exception.NoTrackExistException;
import com.stackroute.muzix.exception.TrackAlreadyExistException;
import com.stackroute.muzix.exception.TrackDoesNotExistException;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component("dummyTrackService")
@Configuration
@Profile("dummy")
public class DummyTrackService implements TrackService {

    private TrackRepository trackRepository;

    @Autowired
    public DummyTrackService(TrackRepository trackRepository){this.trackRepository=trackRepository;
        System.out.println("DEV environment started");
//        System.out.println("dummyTrack Service");   //used this line to know the internal functioning
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistException {
        if(trackRepository.existsById(track.getTrackId())) {
            throw new TrackAlreadyExistException("Track Already Exist");
        }
        Track savedTrack=trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public List<Track> getAllTracks() throws NoTrackExistException {
        if(trackRepository.count()==0)
        {
            throw new NoTrackExistException("There is no track available in the saved list");
        }
        return trackRepository.findAll();
    }

    @Override
    public Track updateTrack(int updateId, String comment) throws TrackDoesNotExistException{
        if(!trackRepository.existsById(updateId)) {
            throw new TrackDoesNotExistException("Track is not in the saved list");
        }
        Track track = trackRepository.getOne(updateId);
        Track updatedTrack=new Track();
        updatedTrack.setTrackId(updateId);
        updatedTrack.setTrackName(track.getTrackName());
        updatedTrack.setComment(comment);
        trackRepository.deleteById(updateId);
        trackRepository.save(updatedTrack);
        return updatedTrack;
    }

    @Override
    public Track removeTrack(int deleteId) throws TrackDoesNotExistException{
        if(!trackRepository.existsById(deleteId))
        {
            throw new TrackDoesNotExistException("Track not found");
        }
        Track track=trackRepository.getOne(deleteId);
        trackRepository.deleteById(deleteId);
        return track;
    }

    @Override
    public List<Track> findTracksByName(String trackName) throws NoTrackExistException{
        if(trackRepository.findByTrackName(trackName).size()==0)
        {
            throw new NoTrackExistException("No track found with this name");
        }
        return trackRepository.findByTrackName(trackName);
    }
}
