package com.example.himanishah.udemyadvancedcourse.inmemory;

import com.example.himanishah.udemyadvancedcourse.infrastructure.BeastApplication;
import com.squareup.otto.Bus;

/**
 * Created by himanishah on 8/24/17.
 */

public class BaseInMemory {
    protected final Bus bus;
    protected final BeastApplication application;

    public BaseInMemory(BeastApplication application) {
        this.application = application;
        this.bus = application.getBus();
        bus.register(this);
    }
}

