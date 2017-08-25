package com.example.himanishah.udemyadvancedcourse.views.AboutUsViews;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.himanishah.udemyadvancedcourse.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by himanishah on 8/25/17.
 */

public class AboutUsListHeaderViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.simple_header_textview)
    TextView headerText;
    public AboutUsListHeaderViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
    public void populate(String header){
        headerText.setText(header);
    }

}
