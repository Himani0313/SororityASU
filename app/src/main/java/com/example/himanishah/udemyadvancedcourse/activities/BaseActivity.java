package com.example.himanishah.udemyadvancedcourse.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.himanishah.udemyadvancedcourse.R;
import com.example.himanishah.udemyadvancedcourse.infrastructure.BeastApplication;
import com.squareup.otto.Bus;

public class BaseActivity extends AppCompatActivity {
    protected BeastApplication application;
    protected Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (BeastApplication) getApplication();
        bus = application.getBus();
        bus.register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }
}
