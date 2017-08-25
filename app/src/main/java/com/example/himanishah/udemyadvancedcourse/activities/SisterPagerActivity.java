package com.example.himanishah.udemyadvancedcourse.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.himanishah.udemyadvancedcourse.R;
import com.example.himanishah.udemyadvancedcourse.entities.Sister;
import com.example.himanishah.udemyadvancedcourse.fragments.SisterDetailFragment;
import com.example.himanishah.udemyadvancedcourse.services.SisterServices;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by himanishah on 8/24/17.
 */

public class SisterPagerActivity extends BaseActivity {

    public static final String BROTHER_EXTRA_INFO = "BROTHER_EXTRA_INFO";
    private ArrayList<Sister> sisters;
    @BindView(R.id.activity_sister_pager_viewPager)
    ViewPager sisterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sister_pager);
        ButterKnife.bind(this);
        sisters = new ArrayList<>();
        bus.post(new SisterServices.SearchSisterRequest("Hello"));
        sisterViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Sister sister =sisters.get(position);
                return SisterDetailFragment.newInstance(sister);
            }

            @Override
            public int getCount() {
                return sisters.size();
            }
        });

        Sister sister = getIntent().getParcelableExtra(BROTHER_EXTRA_INFO);
        int sisterId = sister.getSisterId();
        for(int i=0; i<sisters.size(); ++i){
            if(sisters.get(i).getSisterId() == sisterId){
                sisterViewPager.setCurrentItem(i);
                break;
            }
        }
    }

    @Subscribe
    public void getSisters(SisterServices.SearchSisterResponse response){
        sisters.clear();
        sisters.addAll(response.sisters);
    }

    public static Intent newIntent(Context context,Sister sister){
        Intent intent = new Intent(context,SisterPagerActivity.class);
        intent.putExtra(BROTHER_EXTRA_INFO,sister);
        return intent;
    }
}
