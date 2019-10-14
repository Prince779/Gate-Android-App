package com.example.prince.g_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity {
    public static final String YOUTUBE_API_KEY = "AIzaSyCg_250Rvh-Bti4mqajHgsTY5HcRHGGhSs";

    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.tv);

        youTubePlayerView=(YouTubePlayerView)findViewById(R.id.youtube_view);
        onInitializedListener= new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                String VIDEO=  getIntent().getStringExtra("KEY");
                String NA=  getIntent().getStringExtra("NAME");

                youTubePlayer.loadVideo(VIDEO);

                tv.setText(NA);


            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

                youTubePlayerView.initialize(YOUTUBE_API_KEY,onInitializedListener);

    }
}
