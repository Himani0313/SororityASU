package com.example.himanishah.udemyadvancedcourse.views.AboutUsViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.himanishah.udemyadvancedcourse.R;
import com.example.himanishah.udemyadvancedcourse.entities.EventCard;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by himanishah on 8/25/17.
 */

public class SisterHoodViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.list_event_card_eventDescription)
    TextView eventDescription;

    @BindView(R.id.list_event_card_eventName)
    TextView eventName;

    @BindView(R.id.list_event_card_eventType)
    ImageView eventType;

    @BindView(R.id.list_event_card_progressbar)
    ProgressBar eventProgressBar;

    @BindView(R.id.list_event_card_imageView)
    ImageView eventImage;

    public SisterHoodViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void populate(Context context, EventCard eventCard){
        itemView.setTag(eventCard);
        eventDescription.setText(eventCard.getEventDesc());
        eventName.setText(eventCard.getEventName());

        if(!eventCard.isVideo()){
            eventType.setImageResource(R.mipmap.ic_camera);
        }
        else{
            eventType.setImageResource(R.mipmap.ic_video);
        }

        Picasso.with(context).load(eventCard.getEventImage())
                .fit()
                .centerCrop()
                .into(eventImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        eventProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}
