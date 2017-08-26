package com.example.himanishah.udemyadvancedcourse.infrastructure;

import android.app.Application;

import com.example.himanishah.udemyadvancedcourse.inmemory.Module;
import com.squareup.otto.Bus;

/**
 * Created by himanishah on 8/20/17.
 */

public class BeastApplication extends Application {
    private Bus bus;

    public BeastApplication(){
        bus = new Bus();
    }

    public static final String YOUTUBE_KEY = "AIzaSyCWi3vjRDPnNSE-kJhuIhJfaFKEFsxIraI";

    @Override
    public void onCreate() {
        super.onCreate();
        Module.Register(this);
    }

    public Bus getBus() {
        return bus;
    }
}
