package com.example.himanishah.udemyadvancedcourse.inmemory;

import com.example.himanishah.udemyadvancedcourse.entities.EventCard;
import com.example.himanishah.udemyadvancedcourse.infrastructure.BeastApplication;
import com.example.himanishah.udemyadvancedcourse.services.EventCardService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by himanishah on 8/25/17.
 */

public class InMemoryEventCardService extends BaseInMemory{
    public InMemoryEventCardService(BeastApplication application) {
        super(application);
    }

    @Subscribe
    public void searchCommunityCards(EventCardService.SearchCommunityServiceCardRequest request){
        EventCardService.SearchCommunityServiceCardResponse response = new EventCardService.SearchCommunityServiceCardResponse();
        response.communityServiceCards = new ArrayList<>();
        response.communityServiceCards.add(new EventCard(
                1,
                "Community Event 1",
                "Community Event 1's Description",
                "http://www.gravatar.com/avatar/" + 1 + "?d=identicon",
                false,
                "null"
        ));
        response.communityServiceCards.add(new EventCard(
                2,
                "Community Event 2",
                "Community Event 2's Description",
                "http://www.gravatar.com/avatar/" + 2 + "?d=identicon",
                true,
                "null"
        ));
        bus.post(response);
    }

    @Subscribe
    public void searchSisterhoodCards(EventCardService.SearchSisterhoodCardRequest request){
        EventCardService.SearchSisterhoodCardResponse response = new EventCardService.SearchSisterhoodCardResponse();
        response.sisterhoodCards = new ArrayList<>();
        response.sisterhoodCards.add(new EventCard(
                3,
                "SisterHood Event 1",
                "SisterHood Event 1's Description",
                "http://www.gravatar.com/avatar/" + 3 + "?d=identicon",
                false,
                "null"
        ));
        response.sisterhoodCards.add(new EventCard(
                4,
                "SisterHood Event 2",
                "SisterHood Event 2's Description",
                "http://www.gravatar.com/avatar/" + 4 + "?d=identicon",
                true,
                "null"
        ));
        bus.post(response);
    }

    @Subscribe
    public void searchSocialCards(EventCardService.SearchSocialCardRequest request){
        EventCardService.SearchSocialCardResponse response = new EventCardService.SearchSocialCardResponse();
        response.socialCards = new ArrayList<>();
        response.socialCards.add(new EventCard(
                5,
                "Social Event 1",
                "SisterHood Event 1's Description",
                "http://www.gravatar.com/avatar/" + 5 + "?d=identicon",
                false,
                "null"
        ));
        response.socialCards.add(new EventCard(
                6,
                "Social Event 2",
                "Social Event 2's Description",
                "http://www.gravatar.com/avatar/" + 6 + "?d=identicon",
                true,
                "null"
        ));
        bus.post(response);
    }
}
