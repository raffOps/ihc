package com.example.ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    EditText x_axis, y_axis, z_axis;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        x_axis = (EditText) findViewById(R.id.x);
        y_axis = (EditText) findViewById(R.id.y);
        z_axis = (EditText) findViewById(R.id.z);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()== Sensor.TYPE_ACCELEROMETER) {
            float sensorX = event.values[0];
            float sensorY = event.values[1];
            float sensorZ = event.values[2];
            //coordinate.setText(String.valueOf(sensorX) + " " + String.valueOf(sensorY) + " " + String.valueOf(sensorZ));
            x_axis.setText("X: " + String.valueOf(sensorX));
            y_axis.setText("Y: " + String.valueOf(sensorY));
            z_axis.setText("Z: " + String.valueOf(sensorZ));
            if(sensorZ < 0){
                Intent in = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(in);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {
    }
}