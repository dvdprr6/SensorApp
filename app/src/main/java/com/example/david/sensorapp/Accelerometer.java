package com.example.david.sensorapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import utils.BackButton;

public class Accelerometer extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor accelerometerSensor;

    private TextView outputX;
    private TextView outputY;
    private TextView outputZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        Button backButton = findViewById(R.id.back_btn);

        outputX = findViewById(R.id.AccTextViewX);
        outputY = findViewById(R.id.AccTextViewY);
        outputZ = findViewById(R.id.AccTextViewZ);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        backButton.setOnClickListener(new BackButton("Accelerometer", this));
    }

    @Override
    protected void onStart(){
        super.onStart();
        sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onStop(){
        super.onStop();
        sensorManager.unregisterListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));
    }

    @Override
    public void onSensorChanged(SensorEvent event){
        float[] values = event.values;

        outputX.setText("x: " + values[0]);
        outputY.setText("y: " + values[1]);
        outputZ.setText("z: " + values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){

    }
}
