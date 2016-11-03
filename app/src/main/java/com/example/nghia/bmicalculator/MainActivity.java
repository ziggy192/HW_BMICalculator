package com.example.nghia.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    EditText editTextweight;
    EditText editTextHeight;
    TextView result;
    Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onClick");
        getReferences();
        addListeners();

    }

    private void addListeners() {
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightText = new String();
                String heightText = new String();

                try {
                    weightText = editTextweight.getText().toString();
                    heightText = editTextHeight.getText().toString();
                    double weight = Integer.parseInt(weightText);
                    double height = Integer.parseInt(heightText) / 100.0;

                    double BMI = weight / (height * height);
                BMI = Math.round(BMI*10)/10.0;
                    String resultText = "Your BMI is " + BMI + ", ";
                    if (BMI < 16) {
                        resultText += "Severely underweight";
                    } else if (BMI < 18.5) {
                        resultText += "Underweight";
                    } else if (BMI < 25) {
                        resultText += "Normal";
                    } else if (BMI < 30) {
                        resultText += "Overweight";
                    } else resultText = "Obese";
                    result.setText(resultText);
                } catch (Exception ex) {
                    result.setText("Invalid Input");
                }

            }
        });
    }

    private void getReferences() {
        editTextHeight = (EditText) findViewById(R.id.et_height);
        editTextweight = (EditText) findViewById(R.id.et_weight);
        result = (TextView) findViewById(R.id.tv_result);
        buttonCalculate = (Button) findViewById(R.id.bt_calculate);


    }
}
