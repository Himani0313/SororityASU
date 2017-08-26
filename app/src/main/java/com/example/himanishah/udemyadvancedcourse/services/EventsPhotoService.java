package com.example.himanishah.udemyadvancedcourse.services;

import com.example.himanishah.udemyadvancedcourse.entities.EventCard;
import com.example.himanishah.udemyadvancedcourse.entities.EventPicture;

import java.util.List;

/**
 * Created by himanishah on 8/25/17.
 */

public class EventsPhotoService {

    private EventsPhotoService(){

    }
    public static class SearchCommunityPhotoRequest{
        public String fireBaseUrl;

        public SearchCommunityPhotoRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }
    public static class SearchCommunityPhotoResponse{
        public List<EventPicture> communityPhotos;
    }
    public static class SearchSisterhoodPhotoRequest{
        public String fireBaseUrl;

        public SearchSisterhoodPhotoRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }
    public static class SearchSisterhoodPhotoResponse{
        public List<EventPicture> sisterhoodPhotos;
    }
    public static class SearchSocialPhotoRequest{
        public String fireBaseUrl;

        public SearchSocialPhotoRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }
    public static class SearchSocialPhotoResponse{
        public List<EventPicture> socialPhotos;
    }
}
