package com.example.ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor light;
    TextView lightValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lightValue = (TextView)findViewById(R.id.light);
        sensorManager = (SensorManager)
                getSystemService(Context.SENSOR_SERVICE);
        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if(light != null)
        {
            sensorManager.registerListener(MainActivity.this, light,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }else
        {
            lightValue.setText("Light sensor not supported");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        if(sensor.getType() == Sensor.TYPE_LIGHT)
        {
            lightValue.setText("Light Intensity: " + event.values[0]);
        }
    }
}