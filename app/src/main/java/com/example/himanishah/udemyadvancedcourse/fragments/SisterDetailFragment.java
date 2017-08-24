package com.example.himanishah.udemyadvancedcourse.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.himanishah.udemyadvancedcourse.R;
import com.example.himanishah.udemyadvancedcourse.entities.Sister;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by himanishah on 8/24/17.
 */

public class SisterDetailFragment extends BaseFragment {

    @BindView(R.id.fragment_sister_detail_name)
    TextView sisterName;

    @BindView(R.id.fragment_sister_detail_sisMajor)
    TextView sisterMajor;

    @BindView(R.id.fragment_sister_detail_sisterCrossed)
    TextView sisterCrossed;

    @BindView(R.id.fragment_sister_detail_funFact)
    TextView sisterFunFact;

    @BindView(R.id.fragment_sister_detail_sisterWhyjoined)
    TextView sisterWhyJoined;

    @BindView(R.id.fragment_sister_detail_sisterPic)
    ImageView sisterPic;

    @BindView(R.id.fragment_sister_detail_progressBar)
    ProgressBar progressBar;

    private Sister sister;
    private final String BROTHER_EXTRA_INFO = "BROTHER_EXTRA_INFO";

    public static SisterDetailFragment newInstance(){
        return new SisterDetailFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sister = getActivity().getIntent().getParcelableExtra(BROTHER_EXTRA_INFO);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sister_details, container, false);
        ButterKnife.bind(this,rootView);
        sisterName.setText(sister.getSisterName());
        sisterFunFact.setText(getString(R.string.fun_fact_intro,sister.getSisterFunFact()));
        sisterMajor.setText(getString(R.string.major_intro,sister.getSisterMajor()));
        sisterCrossed.setText(getString(R.string.crossed_sem_intro, sister.getSisterSemester()));
        sisterWhyJoined.setText(sister.getSisterWhyJoin());
        Picasso.with(getActivity()).load(sister.getSisterPic())
                .fit()
                .centerCrop()
                .into(sisterPic, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });

        return rootView;
    }
}
