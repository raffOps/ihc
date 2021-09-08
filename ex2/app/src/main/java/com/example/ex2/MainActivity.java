package com.example.ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText message_input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message_input = (EditText) findViewById(R.id.message_input);
    }
    public void Send(View view)
    {
        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("message_input", message_input.getText().toString());
        startActivity(i);
    }
}