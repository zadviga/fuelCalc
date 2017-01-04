package com.example.zen.p0301_activityresult;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class MileageActivity extends Activity implements View.OnClickListener {

    TextView refillPetrolLiter;
    EditText enterRefillPetrolLiter;
    TextView tripDistance;
    EditText enterTripDistance;
    Button calculateFlowButton;
    Button clearMileageButton;
    TextView resultFlowArea;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mileage);

        refillPetrolLiter = (TextView) findViewById(R.id.refillPetrolLiter);
        enterRefillPetrolLiter = (EditText) findViewById(R.id.enteRrefillPetrolLiter);
        tripDistance = (TextView) findViewById(R.id.tripDistance);
        enterTripDistance = (EditText) findViewById(R.id.enterTripDistance);
        calculateFlowButton = (Button) findViewById(R.id.calculateFlowButton);
        clearMileageButton = (Button) findViewById(R.id.clearFlowFields);
        resultFlowArea = (TextView) findViewById(R.id.resultFlowArea);
        calculateFlowButton.setOnClickListener(this);
        clearMileageButton.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mileage, menu);
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
        double result;

        if (TextUtils.isEmpty(enterRefillPetrolLiter.getText().toString()) | (TextUtils.isEmpty(enterTripDistance.getText().toString()))) {
            Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
            return;
        }

        double refillPetrolLiterCollum = Double.parseDouble(enterRefillPetrolLiter.getText().toString());
        double tripDistanceCollum = Double.parseDouble(enterTripDistance.getText().toString());

        switch (view.getId()) {
            case R.id.calculateFlowButton:
                result = (refillPetrolLiterCollum / tripDistanceCollum) * 100;
                double resultFlow = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
                String stringFlowResult = Double.toString(resultFlow);
                resultFlowArea.setText("Расход л/100км: " + " " + stringFlowResult);
                break;
            case R.id.clearFlowFields:
                enterRefillPetrolLiter.setText("");
                enterTripDistance.setText("");
                resultFlowArea.setText("");
                Toast.makeText(this, "Очищено", Toast.LENGTH_SHORT).show();
                break;
        }


    }
}
