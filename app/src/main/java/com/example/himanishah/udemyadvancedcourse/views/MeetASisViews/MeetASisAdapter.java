package com.example.himanishah.udemyadvancedcourse.views.MeetASisViews;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.himanishah.udemyadvancedcourse.R;
import com.example.himanishah.udemyadvancedcourse.activities.BaseActivity;
import com.example.himanishah.udemyadvancedcourse.entities.Sister;

import java.util.ArrayList;

/**
 * Created by himanishah on 8/19/17.
 */

public class MeetASisAdapter extends RecyclerView.Adapter<MeetASisViewHolder> implements View.OnClickListener{

    private LayoutInflater inflater;
    private BaseActivity activity;
    private OnSisterClicked listener;
    private ArrayList<Sister> sisters;

    public MeetASisAdapter(BaseActivity activity, OnSisterClicked listener) {
        this.activity = activity;
        this.listener = listener;
        inflater = activity.getLayoutInflater();
        sisters = new ArrayList<>();
    }

    public ArrayList<Sister> getSisters() {
        return sisters;
    }

    @Override
    public MeetASisViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listView = inflater.inflate(R.layout.list_meet_a_sis, parent, false);
        listView.setOnClickListener(this);
        return new MeetASisViewHolder(listView);
    }

    @Override
    public void onBindViewHolder(MeetASisViewHolder holder, int position) {
        holder.populate(activity,sisters.get(position));
    }

    @Override
    public int getItemCount() {
        return sisters.size();
    }

    @Override
    public void onClick(View v) {
        if(v.getTag() instanceof Sister){
            Sister sister = (Sister)v.getTag();
            listener.onSisterClicked(sister);
        }
    }

    public interface OnSisterClicked{
        void onSisterClicked(Sister sister);
    }
}
