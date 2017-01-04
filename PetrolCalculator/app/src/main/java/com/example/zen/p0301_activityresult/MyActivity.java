package com.example.zen.p0301_activityresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class MyActivity extends Activity implements View.OnClickListener {

    Button coastTripButton;
    Button aboutButton;
    Button flowButton;
    ImageButton imageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        coastTripButton = (Button) findViewById(R.id.coastTripButton);
        aboutButton = (Button) findViewById(R.id.aboutButton);
        flowButton = (Button) findViewById(R.id.flowButton);
        coastTripButton.setOnClickListener(this);
        aboutButton.setOnClickListener(this);
        flowButton.setOnClickListener(this);

        addListenerOnButton();
    }

    private void addListenerOnButton() {
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyActivity.this, "Drive Safely", Toast.LENGTH_SHORT).show();
          //      Intent intent = new Intent(this, AboutActivity.class);
           //     startActivity(intent);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.coastTripButton:
                Intent intentCalculate = new Intent(this, CoastActivity.class);
                startActivity(intentCalculate);
                break;
            case R.id.flowButton:
                Intent intentFlow = new Intent(this, MileageActivity.class);
                startActivity(intentFlow);
                break;
            case R.id.aboutButton:
                Intent intentAbout = new Intent(this, AboutActivity.class);
                startActivity(intentAbout);
                break;

        }


    }


}

