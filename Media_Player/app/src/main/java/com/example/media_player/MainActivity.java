package com.example.media_player;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private TextView txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPlay = findViewById(R.id.btnPlay);
        Button btnStop = findViewById(R.id.btnStop);
        txtStatus = findViewById(R.id.txtStatus);

        // Initialize MediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.music);
        mediaPlayer.setOnCompletionListener(mp -> txtStatus.setText("Status: Finished"));

        btnPlay.setOnClickListener(v -> {
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
                txtStatus.setText("Status: Playing");
            }
        });

        btnStop.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
                txtStatus.setText("Status: Stopped");
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
