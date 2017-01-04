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


public class CoastActivity extends Activity implements View.OnClickListener {

    EditText enterPetrolKm;
    EditText enterCoastLiter;
    EditText enterDistance;
    TextView resultView;
    Button calculateButton;
    Button clearFields;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coast);

        enterPetrolKm = (EditText) findViewById(R.id.enterPetrolKm);
        enterCoastLiter = (EditText) findViewById(R.id.enterCoastLiter);
        enterDistance = (EditText) findViewById(R.id.enterDistance);
        resultView = (TextView) findViewById(R.id.resultView);
        calculateButton = (Button) findViewById(R.id.calculateButton);
        clearFields = (Button) findViewById(R.id.clearFields);
        calculateButton.setOnClickListener(this);
        clearFields.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.coast, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        double result;

        if (TextUtils.isEmpty(enterPetrolKm.getText().toString()) | (TextUtils.isEmpty(enterCoastLiter.getText().toString()) | (TextUtils.isEmpty(enterDistance.getText().toString())))) {
            Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
            return;
        }

        double literKm = Double.parseDouble(enterPetrolKm.getText().toString());
        double literCoast = Double.parseDouble(enterCoastLiter.getText().toString());
        double distance = Double.parseDouble(enterDistance.getText().toString());


        switch (view.getId()) {
            case R.id.calculateButton:
                result = (distance / 100) * literKm * literCoast;
                double roundResult = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
                String stringResult = Double.toString(roundResult);
                resultView.setText("Стоимость поездки: " + "  " + stringResult + " денег");
                break;

            case R.id.clearFields:
                enterCoastLiter.setText("");
                enterPetrolKm.setText("");
                enterDistance.setText("");
                resultView.setText("");
                Toast.makeText(this, "Очищено", Toast.LENGTH_SHORT).show();
            default:
                break;
        }


    }
}
