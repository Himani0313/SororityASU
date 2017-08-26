package com.example.himanishah.udemyadvancedcourse.services;

import com.example.himanishah.udemyadvancedcourse.entities.EventCard;

import java.util.List;

/**
 * Created by himanishah on 8/25/17.
 */

public class EventCardService {
    public static class SearchCommunityServiceCardRequest{
        public String fireBaseUrl;

        public SearchCommunityServiceCardRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }
    public static class SearchCommunityServiceCardResponse{
        public List<EventCard> communityServiceCards;
    }
    public static class SearchSisterhoodCardRequest{
        public String fireBaseUrl;

        public SearchSisterhoodCardRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }
    public static class SearchSisterhoodCardResponse{
        public List<EventCard> sisterhoodCards;
    }
    public static class SearchSocialCardRequest{
        public String fireBaseUrl;

        public SearchSocialCardRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }
    public static class SearchSocialCardResponse{
        public List<EventCard> socialCards;
    }
}
