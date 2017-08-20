package com.example.himanishah.udemyadvancedcourse.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.himanishah.udemyadvancedcourse.infrastructure.BeastApplication;
import com.squareup.otto.Bus;

/**
 * Created by himanishah on 8/20/17.
 */

public class BaseFragment extends Fragment{
    protected Bus bus;
    protected BeastApplication application;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (BeastApplication)getActivity().getApplication();
        bus = application.getBus();
        bus.register(this);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }
}
