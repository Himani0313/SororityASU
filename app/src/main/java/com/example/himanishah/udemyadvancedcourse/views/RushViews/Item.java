package com.example.himanishah.udemyadvancedcourse.views.RushViews;

import com.example.himanishah.udemyadvancedcourse.entities.RushEvents;

import java.util.List;

/**
 * Created by himanishah on 8/28/17.
 */

public class Item {
    public int type;
    public String header;
    public RushEvents rushEvents;
    public List<Item> invisibleChildren;

    public Item(int type, String header) {
        this.type = type;
        this.header = header;
    }

    public Item(int type, RushEvents rushEvents) {
        this.type = type;
        this.rushEvents = rushEvents;
    }
}
