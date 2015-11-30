package com.example.ivanvillalobos.kcwm;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

public class Exhibit3b extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener, Runnable, View.OnClickListener, SeekBar.OnSeekBarChangeListener{


    private GestureDetectorCompat gestureDetector;
    private static final int SWIPE_DISTANCE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;


    private SeekBar seek_bar;
    MediaPlayer audio;
    private ImageButton startMedia;
    private ImageButton stopMedia;
    int paused;




    private android.support.v7.widget.Toolbar toolbar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_exhibits, menu);

        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibit3b);

        this.gestureDetector= new GestureDetectorCompat(this,this);
        gestureDetector.setOnDoubleTapListener(this);

        seek_bar = (SeekBar) findViewById(R.id.seek_bar);
        startMedia = (ImageButton) findViewById(R.id.play);
        stopMedia = (ImageButton) findViewById(R.id.stop);
        startMedia.setOnClickListener(this);
        stopMedia.setOnClickListener(this);
        seek_bar.setOnSeekBarChangeListener(this);
        seek_bar.setEnabled(false);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



    }

    public void run() {
        int currentPosition = audio.getCurrentPosition();
        int total = audio.getDuration();

        while (audio != null && currentPosition < total) {
            try {
                Thread.sleep(1000);
                currentPosition = audio.getCurrentPosition();
            } catch (InterruptedException e) {
                return;
            } catch (Exception e) {
                return;
            }
            seek_bar.setProgress(currentPosition);
        }
    }

    public void onClick(View v) {
        if (v.equals(startMedia)) {
            startMedia.setImageResource(R.mipmap.pause);

            if (audio == null) {
                audio = MediaPlayer.create(getApplicationContext(), R.raw.script2area3);
                seek_bar.setEnabled(true);
            }
            if (audio.isPlaying()) {

                audio.pause();
                startMedia.setImageResource(R.mipmap.play);

            } else {
                audio.start();

                seek_bar.setMax(audio.getDuration());
                new Thread(this).start();
            }
        }
        if (v.equals(stopMedia) && audio != null) {
            startMedia.setImageResource(R.mipmap.play);

            if (audio.isPlaying() || audio.getDuration() > 0) {
                audio.stop();
                audio = null;

                seek_bar.setProgress(0);
            }
        }


    }

    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
        try {
            if (audio.isPlaying() || audio != null) {
                if (fromUser)
                    audio.seekTo(progress);
            } else if (audio == null) {
                Toast.makeText(getApplicationContext(), "Media is not running",
                        Toast.LENGTH_SHORT).show();
                seekBar.setProgress(0);
            }
        } catch (Exception e) {
            Log.e("seek bar", "" + e);
            seekBar.setEnabled(false);

        }
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id==R.id.navigate){
            startActivity(new Intent(this, Exhibit4.class));
            if(audio != null) {
                audio.release();
            }
            finish();

        }

        if(id==R.id.navigatePrevious){
            startActivity(new Intent(this, Exhibit2.class));
            if(audio != null) {
                audio.release();
            }
            finish();

        }

        if(id==R.id.map){
            startActivity(new Intent(this, Map.class));
            if(audio != null) {
                audio.release();
            }
            finish();

        }


        return super.onOptionsItemSelected(item);



    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {

        return true;

    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {

        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {

        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {

        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {


    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {

        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    public void onSwipeLeft() {


    }
    public void onSwipeRight() {

        Intent myIntent = new Intent(Exhibit3b.this, Exhibit3.class);
        Exhibit3b.this.startActivity(myIntent);
        if(audio != null) {
            audio.release();
        }
        finish();

    }


    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float distanceX = e2.getX() - e1.getX();
        float distanceY = e2.getY() - e1.getY();
        if (Math.abs(distanceX) > Math.abs(distanceY) && Math.abs(distanceX) > SWIPE_DISTANCE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
            if (distanceX > 0)
                onSwipeRight();
            else
                onSwipeLeft();
            return true;
        }
        return false;
    }

}

