//package com.stackroute.muzix.applicationlistner;
//
//import com.stackroute.muzix.domain.Track;
//import com.stackroute.muzix.exception.TrackAlreadyExistException;
//import com.stackroute.muzix.service.TrackService;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ApplicationListener1 implements ApplicationListener<ContextRefreshedEvent> {
//
//
//    public TrackService trackService;
//
//    public ApplicationListener1( TrackService trackService) {
////        System.out.println("in Application controller");  //used this line to know the internal functioning
//        this.trackService = trackService;
//    }
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        Track track1=new Track(1,"firstTrack","This is nice track");
//        Track track2=new Track(2,"secondTrack","This is bad track");
//        try {
//            trackService.saveTrack(track1);
//
//        } catch (TrackAlreadyExistException e) {
//            e.printStackTrace();
//        }
//        try {
//            trackService.saveTrack(track2);
//        } catch (TrackAlreadyExistException e) {
//            e.printStackTrace();
//        }
//    }
//}
