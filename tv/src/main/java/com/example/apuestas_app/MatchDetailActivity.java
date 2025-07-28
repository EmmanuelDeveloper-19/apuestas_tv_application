package com.example.apuestas_app;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apuestas_app.models.Match;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MatchDetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_detail_activity);

        VideoView videoView = findViewById(R.id.richardVideo);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.richard_sanchez);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.start();

    }
}
