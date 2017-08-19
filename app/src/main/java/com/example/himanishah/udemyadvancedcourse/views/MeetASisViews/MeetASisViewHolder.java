package com.example.himanishah.udemyadvancedcourse.views.MeetASisViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.himanishah.udemyadvancedcourse.R;
import com.example.himanishah.udemyadvancedcourse.entities.Sister;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by himanishah on 8/19/17.
 */

public class MeetASisViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.list_meet_a_sis_ImageView)
    ImageView sisterPic;
    @BindView(R.id.list_meet_a_sis_ProgressBar)
    ProgressBar sisterProgressBar;


    public MeetASisViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
    public void populate (Context context, Sister sister){
        itemView.setTag(sister);
        Picasso.with(context).load(sister.getSisterPic())
                .fit()
                .centerCrop()
                .into(sisterPic, new Callback() {
                    @Override
                    public void onSuccess() {
                        sisterProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}
