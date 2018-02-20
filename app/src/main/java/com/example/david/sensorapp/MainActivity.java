package com.example.david.sensorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final static int SPY = 5;
    public final static String INTENT_RESULT_ACTIVITY_MAIN = "hello";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button accelerometerButton = findViewById(R.id.accBtn);
        Button gyroscopeButton = findViewById(R.id.gyroBtn);

        accelerometerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent accelerometerActivityIntent = new Intent(MainActivity.this, Accelerometer.class);
                startActivityForResult(accelerometerActivityIntent, SPY);
            }
        });

        gyroscopeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent gyroscopeActivityIntent = new Intent(MainActivity.this, Gyroscope.class);
                startActivityForResult(gyroscopeActivityIntent, SPY);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == SPY && resultCode == RESULT_OK){
            Toast.makeText(this, "You came back from " + data.getStringExtra(INTENT_RESULT_ACTIVITY_MAIN), Toast.LENGTH_SHORT).show();
        }
    }
}
