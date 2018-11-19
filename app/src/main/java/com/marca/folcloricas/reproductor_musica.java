package com.marca.folcloricas;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class reproductor_musica  extends AppCompatActivity {

    Button playBtn;
    SeekBar positionBar;
    TextView elapsedTimeLabel;
    TextView remainingTimeLabel;
    MediaPlayer mp;
    int totalTime;
    ImageView img;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reproductor_musica);
        Intent i= getIntent();
        int rawId = getResources().getIdentifier(i.getStringExtra("name"), "raw", getPackageName()); //Cogiendo la cancion correcta
        int drawableId = getResources().getIdentifier(i.getStringExtra("name"), "drawable", getPackageName()); //Cogiendo la foto correcta
        img = (ImageView) findViewById(R.id.imagen_reproductor);
        playBtn = (Button) findViewById(R.id.playBtn);
        elapsedTimeLabel = (TextView) findViewById(R.id.elapsedTimeLabel);
        remainingTimeLabel = (TextView) findViewById(R.id.remainingTimeLabel);
        img.setImageResource(drawableId);
        // Media Player
        mp = MediaPlayer.create(this, rawId);
        mp.setLooping(true);
        mp.seekTo(0);
        mp.setVolume(0.5f, 0.5f);
        totalTime = mp.getDuration();

        // Position Bar
        positionBar = (SeekBar) findViewById(R.id.positionBar);
        positionBar.setMax(totalTime);
        positionBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser) {
                            mp.seekTo(progress);
                            positionBar.setProgress(progress);
                        }
                    }

                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }


                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );





        // Thread (Update positionBar & timeLabel)
        new Thread(new Runnable() {

            public void run() {
                while (mp != null) {
                    try {
                        Message msg = new Message();
                        msg.what = mp.getCurrentPosition();
                        handler.sendMessage(msg);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {}
                }
            }
        }).start();

    }

    private Handler handler = new Handler() {

        public void handleMessage(Message msg) {
            int currentPosition = msg.what;
            // Update positionBar.
            positionBar.setProgress(currentPosition);

            // Update Labels.
            String elapsedTime = createTimeLabel(currentPosition);
            elapsedTimeLabel.setText(elapsedTime);

            String remainingTime = createTimeLabel(totalTime-currentPosition);
            remainingTimeLabel.setText("- " + remainingTime);
        }
    };

    public String createTimeLabel(int time) {
        String timeLabel = "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;
    }

    public void playBtnClick(View view) {

        if (!mp.isPlaying()) {
            // Stopping
            mp.start();
            playBtn.setBackgroundResource(R.drawable.stop);

        } else {
            // Playing
            mp.pause();
            playBtn.setBackgroundResource(R.drawable.play);
        }

    }
}
