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

public class Gyroscope extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor gyroscopeSensor;

    private TextView outputX;
    private TextView outputY;
    private TextView outputZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);

        Button backButton = findViewById(R.id.back_btn);

        outputX = findViewById(R.id.GyroTextViewX);
        outputY = findViewById(R.id.GyroTextViewY);
        outputZ = findViewById(R.id.GyroTextViewZ);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        backButton.setOnClickListener(new BackButton("Gyroscope", this));
    }

    @Override
    protected void onStart(){
        super.onStart();
        sensorManager.registerListener(this, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onStop(){
        super.onStop();
        sensorManager.unregisterListener(this, gyroscopeSensor);
    }

    @Override
    public void onSensorChanged(SensorEvent event){
        float[] values = event.values;

        outputX.setText("x: " + values[0]);
        outputY.setText("y: " + values[1]);
        outputZ.setText("z: " + values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){}
}
