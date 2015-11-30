package com.example.ivanvillalobos.kcwm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;



public class Map extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_map, menu);

        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

       toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Locate the button in activity_map.xml
        Button buttonex1 = (Button) findViewById(R.id.buttonex1);
        Button buttonex2 = (Button) findViewById(R.id.buttonex2);
        Button buttonex3 = (Button) findViewById(R.id.buttonex3);
        Button buttonex4 = (Button) findViewById(R.id.buttonex4);
        Button buttonex5 = (Button) findViewById(R.id.buttonex5);
        Button buttonex6 = (Button) findViewById(R.id.buttonex6);
        Button buttonex7 = (Button) findViewById(R.id.buttonex7);
        Button buttonex8 = (Button) findViewById(R.id.buttonex8);
        Button buttonex9 = (Button) findViewById(R.id.buttonex9);
        Button buttonex10 = (Button) findViewById(R.id.buttonex10);

        // Capture button clicks
        buttonex1.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Map.this,
                        Exhibit.class);
                startActivity(myIntent);
                finish();
            }
        });

        // Capture button clicks
        buttonex2.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Map.this,
                        Exhibit2.class);
                startActivity(myIntent);
                finish();
            }
        });

        // Capture button clicks
        buttonex3.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Map.this,
                        Exhibit3.class);
                startActivity(myIntent);
                finish();
            }
        });
        // Capture button clicks
        buttonex4.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Map.this,
                        Exhibit4.class);
                startActivity(myIntent);
                finish();
            }
        });
        // Capture button clicks
        buttonex5.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Map.this,
                        Exhibit5.class);
                startActivity(myIntent);
                finish();
            }
        });
        // Capture button clicks
        buttonex6.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Map.this,
                        Exhibit6.class);
                startActivity(myIntent);
                finish();
            }
        });
        // Capture button clicks
        buttonex7.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Map.this,
                        Exhibit7.class);
                startActivity(myIntent);
                finish();
            }
        });
        // Capture button clicks
        buttonex8.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Map.this,
                        Exhibit8.class);
                startActivity(myIntent);
                finish();
            }
        });
        // Capture button clicks
        buttonex9.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Map.this,
                        Exhibit9.class);
                startActivity(myIntent);
                finish();
            }
        });

        // Capture button clicks
        buttonex10.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Map.this,
                        Exhibit10.class);
                startActivity(myIntent);
                finish();
            }
        });




    }




    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id==R.id.navigate){
            startActivity(new Intent(this, Exhibit.class));

        }

        return super.onOptionsItemSelected(item

    );
    }



}
