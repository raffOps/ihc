package com.example.ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText number1, number2;
    private TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1 = (EditText) (findViewById(R.id.number1));
        number2 = (EditText) (findViewById(R.id.number2));
        txtResult = (TextView) (findViewById(R.id.result));
    }

    public void sum(View v) {
        int number_1 = Integer.parseInt(number1.getText().toString());
        int number_2 = Integer.parseInt(number2.getText().toString());
        int sum = number_1 + number_2;
        Toast.makeText(MainActivity.this, "Result: " + sum, Toast.LENGTH_LONG).show();
        txtResult.setText("Result: " + String.valueOf(sum));
    }

    }