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
////@Order(value=1)
//public class CommandLineRunnerStarter2 implements CommandLineRunner {
//
//    private TrackService trackService;
//
//    public CommandLineRunnerStarter2(TrackService trackService) {
////        System.out.println("in CLR2");  //used this line to know the internal functioning
//        this.trackService = trackService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        trackService.saveTrack(new Track(5,"five","this track is taken by CLR and listed in 2"));
//        trackService.saveTrack(new Track(6,"six","this track is taken by CLR and on 2nd number in the world listed in 2"));
//    }
//}
