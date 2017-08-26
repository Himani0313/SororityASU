package com.example.himanishah.udemyadvancedcourse.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.himanishah.udemyadvancedcourse.R;
import com.example.himanishah.udemyadvancedcourse.entities.EventPicture;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by himanishah on 8/25/17.
 */

public class EventsPhotoFragment extends BaseFragment {

    @BindView(R.id.fragment_event_pic_ImageView)
    ImageView eventsPic;

    @BindView(R.id.fragment_event_pic_ProgressBar)
    ProgressBar eventProgressBar;

    public static final String EVENT_PHOTO_INFO = "EVENT_PHOTO_INFO";
    private String photoUrl;

    public static EventsPhotoFragment newInstance(EventPicture eventPicture){
        Bundle arguments = new Bundle();
        arguments.putString(EVENT_PHOTO_INFO, eventPicture.getPicURL());
        EventsPhotoFragment eventsPhotoFragment = new EventsPhotoFragment();
        eventsPhotoFragment.setArguments(arguments);
        return eventsPhotoFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        photoUrl = getArguments().getString(EVENT_PHOTO_INFO);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_event_pic,container,false);
        ButterKnife.bind(this,rootView);
        Picasso.with(getActivity()).load(photoUrl)
                .fit()
                .centerCrop()
                .into(eventsPic, new Callback() {
                    @Override
                    public void onSuccess() {
                        eventProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });

        return rootView;
    }
}
