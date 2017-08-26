package com.example.himanishah.udemyadvancedcourse.inmemory;

import com.example.himanishah.udemyadvancedcourse.entities.EventPicture;
import com.example.himanishah.udemyadvancedcourse.infrastructure.BeastApplication;
import com.example.himanishah.udemyadvancedcourse.services.EventsPhotoService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by himanishah on 8/25/17.
 */

public class InMememoryPicService extends BaseInMemory {
    public InMememoryPicService(BeastApplication application) {
        super(application);
    }
    @Subscribe
    public void getCommunityPhotos(EventsPhotoService.SearchCommunityPhotoRequest request){
        EventsPhotoService.SearchCommunityPhotoResponse response = new EventsPhotoService.SearchCommunityPhotoResponse();
        response.communityPhotos = new ArrayList<>();
        response.communityPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 50 + "?d=identicon"));
        response.communityPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 51 + "?d=identicon"));
        response.communityPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 52 + "?d=identicon"));
        bus.post(response);
    }
    @Subscribe
    public void getSisterhoodPhotos(EventsPhotoService.SearchSisterhoodPhotoRequest request){
        EventsPhotoService.SearchSisterhoodPhotoResponse response = new EventsPhotoService.SearchSisterhoodPhotoResponse();
        response.sisterhoodPhotos = new ArrayList<>();
        response.sisterhoodPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 53 + "?d=identicon"));
        response.sisterhoodPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 54 + "?d=identicon"));
        response.sisterhoodPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 55 + "?d=identicon"));
        bus.post(response);
    }

    @Subscribe
    public void getSocialPhotos(EventsPhotoService.SearchSocialPhotoRequest request){
        EventsPhotoService.SearchSocialPhotoResponse response = new EventsPhotoService.SearchSocialPhotoResponse();
        response.socialPhotos = new ArrayList<>();
        response.socialPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 56 + "?d=identicon"));
        response.socialPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 57 + "?d=identicon"));
        response.socialPhotos.add(new EventPicture("http://www.gravatar.com/avatar/" + 58 + "?d=identicon"));
        bus.post(response);
    }
}
