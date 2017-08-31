package com.example.himanishah.udemyadvancedcourse.inmemory;

import com.example.himanishah.udemyadvancedcourse.entities.RushEvents;
import com.example.himanishah.udemyadvancedcourse.infrastructure.BeastApplication;
import com.example.himanishah.udemyadvancedcourse.services.RushEventsService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by himanishah on 8/29/17.
 */

public class InMemoryRushEventService extends BaseInMemory{
    public InMemoryRushEventService(BeastApplication application) {
        super(application);
    }
    @Subscribe
    public void getCommunityServiceEvents(RushEventsService.SearchRushEventCommunityRequest request){
        RushEventsService.SearchRushEventCommunityResponse response = new RushEventsService.SearchRushEventCommunityResponse();
        response.communityRushEvents = new ArrayList<>();
        response.communityRushEvents.add(new RushEvents(
                1,
                "Rush Community Event 1",
                "08/28/2017",
                "8:00pm",
                "MU 202",
                2.2,2.2,
                true,
                "This is were the description of the event goes!"

        ));
        response.communityRushEvents.add(new RushEvents(
                2,
                "Rush Community Event 2",
                "08/28/2017",
                "8:00pm",
                "MU 202",
                2.2,2.2,
                true,
                "This is were the description of the event goes!"

        ));
        bus.post(response);
    }
    @Subscribe
    public void getSocialRushEvents(RushEventsService.SearchRushEventSocialRequest request){
        RushEventsService.SearchRushEventSocialResponse response = new RushEventsService.SearchRushEventSocialResponse();
        response.socialRushEvents = new ArrayList<>();
        response.socialRushEvents.add(new RushEvents(
                1,
                "Rush Social Event 1",
                "08/28/2017",
                "8:00pm",
                "721 S Mill Ave, Tempe, AZ 85281",
                33.422606,-111.939653,
                false,
                "This is were the description of the event goes!"

        ));
        response.socialRushEvents.add(new RushEvents(
                2,
                "Rush Social Event 2",
                "08/28/2017",
                "8:00pm",
                "MU 202",
                33.422606,-111.939653,
                false,
                "This is were the description of the event goes!"

        ));
        bus.post(response);
    }
}
