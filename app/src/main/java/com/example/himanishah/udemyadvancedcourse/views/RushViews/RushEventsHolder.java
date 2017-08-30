package com.example.himanishah.udemyadvancedcourse.views.RushViews;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.himanishah.udemyadvancedcourse.R;
import com.example.himanishah.udemyadvancedcourse.entities.RushEvents;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by himanishah on 8/28/17.
 */

public class RushEventsHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.list_rush_events_name)
    TextView rushName;

    @BindView(R.id.list_rush_events_date)
    TextView rushDate;

    @BindView(R.id.list_rush_event_time)
    TextView rushTime;

    @BindView(R.id.list_rush_event_location)
    TextView rushLocation;



    public RushEventsHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
    public void populate(RushEvents rushEvents){
        itemView.setTag(rushEvents);
        rushName.setText(rushEvents.getEventName());
        rushDate.setText(rushEvents.getEventDate());
        rushLocation.setText(rushEvents.getEventLocation());
        rushTime.setText(rushEvents.getEventTime());
    }
}
