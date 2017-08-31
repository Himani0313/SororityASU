package com.example.himanishah.udemyadvancedcourse.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.himanishah.udemyadvancedcourse.R;
import com.example.himanishah.udemyadvancedcourse.activities.BaseActivity;
import com.example.himanishah.udemyadvancedcourse.entities.RushEvents;
import com.example.himanishah.udemyadvancedcourse.services.RushEventsService;
import com.example.himanishah.udemyadvancedcourse.views.RushViews.Item;
import com.example.himanishah.udemyadvancedcourse.views.RushViews.RushEventsAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by himanishah on 8/19/17.
 */

public class RushFragment extends BaseFragment implements RushEventsAdapter.RushEventListener{
    private RushEventsAdapter adapter;
    private ArrayList<RushEvents> socialEvents;
    private ArrayList<RushEvents> communityEvents;

    private Item social;
    private Item community;
    private RecyclerView recyclerView;
    public  static RushFragment newInstance(){
        return new RushFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_rush,container,false);
        adapter = new RushEventsAdapter((BaseActivity)getActivity(),this);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_rush_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        socialEvents = new ArrayList<>();
        communityEvents = new ArrayList<>();
        List<Item> data = adapter.getData();

        social = new Item(RushEventsAdapter.VIEW_TYPE_EXPANDABLE_LIST_HEADER,"Social Events");
        social.invisibleChildren = new ArrayList<>();

        community = new Item(RushEventsAdapter.VIEW_TYPE_EXPANDABLE_LIST_HEADER,"Community Events");
        community.invisibleChildren = new ArrayList<>();

        bus.post(new RushEventsService.SearchRushEventCommunityRequest("Hello"));
        bus.post(new RushEventsService.SearchRushEventSocialRequest("Hello"));

        setUpAdapter();

        data.add(community);
        data.add(social);

        return rootView;
    }
    private void setUpAdapter(){
        if(isAdded()){
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void OnRushEventClicked(RushEvents rushEvents) {

    }

    @Subscribe
    public void  getCommunityServiceEvents(RushEventsService.SearchRushEventCommunityResponse response){
        communityEvents.clear();
        communityEvents.addAll(response.communityRushEvents);
        for(RushEvents rushEvents:communityEvents){
            community.invisibleChildren.add(new Item(RushEventsAdapter.VIEW_TYPE_EXPANDABLE_LIST_CHILD,rushEvents));
        }
    }

    @Subscribe
    public void getSocialRushEvents(RushEventsService.SearchRushEventSocialResponse response){
        socialEvents.clear();
        socialEvents.addAll(response.socialRushEvents);
        for(RushEvents rushEvents:socialEvents){
            social.invisibleChildren.add(new Item(RushEventsAdapter.VIEW_TYPE_EXPANDABLE_LIST_CHILD,rushEvents));
        }
    }
}
