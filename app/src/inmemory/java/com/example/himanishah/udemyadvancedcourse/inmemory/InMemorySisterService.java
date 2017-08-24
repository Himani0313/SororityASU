package com.example.himanishah.udemyadvancedcourse.inmemory;

import com.example.himanishah.udemyadvancedcourse.entities.Sister;
import com.example.himanishah.udemyadvancedcourse.infrastructure.BeastApplication;
import com.example.himanishah.udemyadvancedcourse.services.SisterServices;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by himanishah on 8/24/17.
 */

public class InMemorySisterService extends BaseInMemory {
    public InMemorySisterService(BeastApplication application) {
        super(application);
    }

    @Subscribe
    public void getSisters(SisterServices.SearchSisterRequest request){
        SisterServices.SearchSisterResponse response = new SisterServices.SearchSisterResponse();
        response.sisters = new ArrayList<>();

        for(int i=0; i<32;i++){
            response.sisters.add(new Sister(
                    i,
                    "Sister " + i,
                    "Sister " + i + "Joined for this reason",
                    "http://www.gravatar.com/avatar/" + i + "?d=identicon",
                    "Computer science",
                    "Spring 2013",
                    "I love to code my heart out"
            ));
        }
        bus.post(response);
    }
}
