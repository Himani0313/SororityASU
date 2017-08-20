package com.example.himanishah.udemyadvancedcourse.infrastructure;

import android.app.Application;

import com.squareup.otto.Bus;

/**
 * Created by himanishah on 8/20/17.
 */

public class BeastApplication extends Application {
    private Bus bus;

    public BeastApplication(){
        bus = new Bus();
    }

    public Bus getBus() {
        return bus;
    }
}
