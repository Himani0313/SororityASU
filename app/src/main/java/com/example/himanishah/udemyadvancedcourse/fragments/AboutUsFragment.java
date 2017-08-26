package com.example.himanishah.udemyadvancedcourse.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.himanishah.udemyadvancedcourse.R;
import com.example.himanishah.udemyadvancedcourse.activities.BaseActivity;
import com.example.himanishah.udemyadvancedcourse.activities.PhotoPagerActivity;
import com.example.himanishah.udemyadvancedcourse.activities.YoutubeActivity;
import com.example.himanishah.udemyadvancedcourse.entities.EventCard;
import com.example.himanishah.udemyadvancedcourse.services.EventCardService;
import com.example.himanishah.udemyadvancedcourse.views.AboutUsViews.AboutUsAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by himanishah on 8/19/17.
 */

public class AboutUsFragment extends BaseFragment implements AboutUsAdapter.aboutUsListener {
    private ArrayList<EventCard> serviceCards;
    private ArrayList<EventCard> sisterhoodCards;
    private ArrayList<EventCard> socialCards;
    private RecyclerView recyclerView;
    private AboutUsAdapter aboutUsAdapter;


    public  static AboutUsFragment newInstance(){

        return new AboutUsFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about_us,container,false);
        aboutUsAdapter = new AboutUsAdapter((BaseActivity)getActivity(), this);
        serviceCards = aboutUsAdapter.getCommunityServiceEventCards();
        sisterhoodCards = aboutUsAdapter.getSisterHoodEventCards();
        socialCards = aboutUsAdapter.getSocialEventCards();

        recyclerView = (RecyclerView)rootView.findViewById(R.id.fragment_about_us_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        setUpAdapter();

        bus.post(new EventCardService.SearchCommunityServiceCardRequest("Hello"));
        bus.post(new EventCardService.SearchSisterhoodCardRequest("Hello"));
        bus.post(new EventCardService.SearchSocialCardRequest("Hello"));

        return rootView;
    }

    private void setUpAdapter(){
        if(isAdded()){
            recyclerView.setAdapter(aboutUsAdapter);
        }
    }
    @Override
    public void OnEventCardClicked(EventCard eventCard) {
        if(!eventCard.isVideo()){
            Intent intent = PhotoPagerActivity.newIntent(getActivity(),eventCard);
            startActivity(intent);
        }
        else{
            Intent intent = YoutubeActivity.newIntent(getActivity(),eventCard);
            startActivity(intent);
        }
    }

    @Subscribe
    public void getCommunityServiceEvents(EventCardService.SearchCommunityServiceCardResponse response){
        serviceCards.clear();
        serviceCards.addAll(response.communityServiceCards);
    }
    @Subscribe
    public void getsisterhoodEvents(EventCardService.SearchSisterhoodCardResponse response){
        sisterhoodCards.clear();
        sisterhoodCards.addAll(response.sisterhoodCards);
    }
    @Subscribe
    public void getSocialEvents(EventCardService.SearchSocialCardResponse response){
        socialCards.clear();
        socialCards.addAll(response.socialCards);
    }

}
