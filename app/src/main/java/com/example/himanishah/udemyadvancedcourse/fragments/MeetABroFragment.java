package com.example.himanishah.udemyadvancedcourse.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.himanishah.udemyadvancedcourse.R;

/**
 * Created by himanishah on 8/19/17.
 */

public class MeetABroFragment extends Fragment {
    public  static MeetABroFragment newInstance(){
        return new MeetABroFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_meet_a_bro,container,false);
        return rootView;
    }
}
