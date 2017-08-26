package com.example.himanishah.udemyadvancedcourse.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.himanishah.udemyadvancedcourse.R;
import com.example.himanishah.udemyadvancedcourse.entities.EventCard;
import com.example.himanishah.udemyadvancedcourse.infrastructure.BeastApplication;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by himanishah on 8/25/17.
 */

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private String videoUrl;
    public static final String EXTRA_VIDEO_INFO = "EXTRA_VIDEO_INFO";

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_youtube);
        videoUrl = getIntent().getStringExtra(EXTRA_VIDEO_INFO);
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.acivity_youtube_player_view);
        youTubePlayerView.initialize(BeastApplication.YOUTUBE_KEY,this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo(videoUrl);

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }

    public static Intent newIntent(Context context, EventCard eventCard){
        Intent intent = new Intent(context,YoutubeActivity.class);
        intent.putExtra(EXTRA_VIDEO_INFO, eventCard.getYoutubeEnding());
        return intent;
    }
}
