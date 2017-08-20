package com.example.himanishah.udemyadvancedcourse.services;

import com.example.himanishah.udemyadvancedcourse.entities.Sister;

import java.util.List;

/**
 * Created by himanishah on 8/20/17.
 */

public class SisterServices {
    public static class SearchSisterRequest{
        public String fireBaseUrl;

        public SearchSisterRequest(String fireBaseUrl){
            this.fireBaseUrl = fireBaseUrl;
        }


    }
    public static class SearchSisterResponse{
        public List<Sister> sisters;
    }
}
