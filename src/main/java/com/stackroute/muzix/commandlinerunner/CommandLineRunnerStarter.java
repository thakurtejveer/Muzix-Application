//package com.stackroute.muzix.commandlinerunner;
//
//import com.stackroute.muzix.domain.Track;
//import com.stackroute.muzix.service.TrackService;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//@Component
////@Order(value=2) //why the value is not making this to save after the value=1?
//public class CommandLineRunnerStarter implements CommandLineRunner {
//
//    private TrackService trackService;
//
//    public CommandLineRunnerStarter(TrackService trackService) {
////        System.out.println("in CLR1"); //used this line to know the internal functioning
//        this.trackService = trackService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        trackService.saveTrack(new Track(3,"three","this track is taken by CLR"));
//        trackService.saveTrack(new Track(4,"four","this track is taken by CLR and on 2nd number in the world"));
//    }
//}
