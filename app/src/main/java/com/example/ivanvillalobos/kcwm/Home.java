package com.example.ivanvillalobos.kcwm;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.support.v4.view.GestureDetectorCompat;
import android.widget.Toast;


/**
 * Created by ivanvillalobos on 11/2/15.
 */
public class Home extends Map implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener{


    private GestureDetectorCompat gestureDetector;
    private static final int SWIPE_DISTANCE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.


        return true;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        this.gestureDetector= new GestureDetectorCompat(this,this);
        gestureDetector.setOnDoubleTapListener(this);




    }




    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        {
            return true;
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        //Toast.makeText(Home.this, "Single tap!", Toast.LENGTH_SHORT).show();
        //Intent myIntent = new Intent(Home.this, Map.class);
       // Home.this.startActivity(myIntent);
       // finish();
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

        Intent myIntent = new Intent(Home.this, Map.class);
        Home.this.startActivity(myIntent);
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

