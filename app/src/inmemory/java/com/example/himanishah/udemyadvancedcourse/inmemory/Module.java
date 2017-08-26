package com.example.himanishah.udemyadvancedcourse.inmemory;

import com.example.himanishah.udemyadvancedcourse.infrastructure.BeastApplication;

/**
 * Created by himanishah on 8/24/17.
 */

public class Module {
    public static void Register(BeastApplication application){
        new InMemorySisterService(application);
        new InMemoryEventCardService(application);
    }
}
