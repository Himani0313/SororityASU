package com.example.himanishah.udemyadvancedcourse.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.himanishah.udemyadvancedcourse.R;
import com.example.himanishah.udemyadvancedcourse.entities.Sister;
import com.example.himanishah.udemyadvancedcourse.fragments.SisterDetailFragment;

/**
 * Created by himanishah on 8/24/17.
 */

public class PracticeActivity extends BaseActivity {

    public static final String BROTHER_EXTRA_INFO = "BROTHER_EXTRA_INFO";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.activity_practice_fragment_container);
        if (fragment == null){
            fragment = SisterDetailFragment.newInstance();
            fragmentManager.beginTransaction()
                    .add(R.id.activity_practice_fragment_container,fragment)
                    .commit();
        }
    }

    public static Intent newIntent(Context context, Sister sister){
        Intent intent = new Intent(context, PracticeActivity.class);
        intent.putExtra(BROTHER_EXTRA_INFO,sister);
        return intent;
    }
}
