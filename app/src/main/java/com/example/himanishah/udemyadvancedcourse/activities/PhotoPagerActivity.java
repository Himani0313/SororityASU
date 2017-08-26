package com.example.himanishah.udemyadvancedcourse.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.himanishah.udemyadvancedcourse.R;
import com.example.himanishah.udemyadvancedcourse.entities.EventCard;
import com.example.himanishah.udemyadvancedcourse.entities.EventPicture;
import com.example.himanishah.udemyadvancedcourse.fragments.EventsPhotoFragment;
import com.example.himanishah.udemyadvancedcourse.services.EventsPhotoService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by himanishah on 8/25/17.
 */

public class PhotoPagerActivity extends BaseActivity{
    private ArrayList<EventPicture> mEventPhotos;
    @BindView(R.id.activity_photo_pager_viewPager)
    ViewPager viewPager;

    public static final String EXTRA_CARD_INFO = "EXTRA_CARD_INFO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_pager);
        ButterKnife.bind(this);
        mEventPhotos = new ArrayList<>();
        int cardIndex = getIntent().getIntExtra(EXTRA_CARD_INFO,0);

        switch (cardIndex){
            case 1:
                bus.post(new EventsPhotoService.SearchCommunityPhotoRequest("Hello"));
                break;
            case 3:
                bus.post(new EventsPhotoService.SearchSisterhoodPhotoRequest("Hello"));
                break;
            case 5:
                bus.post(new EventsPhotoService.SearchSocialPhotoRequest("Hello"));
                break;
        }
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                EventPicture eventPicture = mEventPhotos.get(position);
                return EventsPhotoFragment.newInstance(eventPicture);
            }

            @Override
            public int getCount() {
                return mEventPhotos.size();
            }
        });
    }

    public static Intent newIntent(Context context, EventCard eventCard){
        Intent intent = new Intent(context, PhotoPagerActivity.class);
        intent.putExtra(EXTRA_CARD_INFO, eventCard.getEventId());
        return intent;
    }

    @Subscribe
    public void getCommunityPhotos(EventsPhotoService.SearchCommunityPhotoResponse response){
        mEventPhotos.clear();
        mEventPhotos.addAll(response.communityPhotos);
    }
    @Subscribe
    public void getSisterhoodPhotos(EventsPhotoService.SearchSisterhoodPhotoResponse response){
        mEventPhotos.clear();
        mEventPhotos.addAll(response.sisterhoodPhotos);
    }
    @Subscribe
    public void getSocialPhotos(EventsPhotoService.SearchSocialPhotoResponse response){
        mEventPhotos.clear();
        mEventPhotos.addAll(response.socialPhotos);
    }
}
