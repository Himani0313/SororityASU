package com.example.himanishah.udemyadvancedcourse.views.RushViews;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.himanishah.udemyadvancedcourse.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by himanishah on 8/28/17.
 */

public class RushExpandableHeaderHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.list_expandable_header_headerName)
    TextView headerName;
    @BindView(R.id.list_expandable_header_buttonToggle)
    ImageView buttonToggle;
    @BindView(R.id.list_expandable_header_layout)
    View backgroundView;


    public RushExpandableHeaderHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
