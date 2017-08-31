package com.example.himanishah.udemyadvancedcourse.services;

import com.example.himanishah.udemyadvancedcourse.entities.RushEvents;

import java.util.List;

/**
 * Created by himanishah on 8/29/17.
 */

public class RushEventsService {
    private RushEventsService(){

    }
    public static class SearchRushEventCommunityRequest{
        public String firebaseUrl;

        public SearchRushEventCommunityRequest(String firebaseUrl) {
            this.firebaseUrl = firebaseUrl;
        }
    }
    public static class SearchRushEventCommunityResponse{
        public List<RushEvents> communityRushEvents;
    }

    public static class SearchRushEventSocialRequest{
        public String firebaseUrl;

        public SearchRushEventSocialRequest(String firebaseUrl) {
            this.firebaseUrl = firebaseUrl;
        }
    }
    public static class SearchRushEventSocialResponse{
        public List<RushEvents> socialRushEvents;
    }
}
