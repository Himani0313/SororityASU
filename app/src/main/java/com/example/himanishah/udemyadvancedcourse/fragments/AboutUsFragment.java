package com.example.himanishah.udemyadvancedcourse.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.himanishah.udemyadvancedcourse.R;

/**
 * Created by himanishah on 8/19/17.
 */

public class AboutUsFragment extends BaseFragment {
    public  static AboutUsFragment newInstance(){
        return new AboutUsFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about_us,container,false);
        return rootView;
    }
}
