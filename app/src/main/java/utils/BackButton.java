package utils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.david.sensorapp.MainActivity;


public class BackButton implements OnClickListener {
    private String returnMessage;
    private AppCompatActivity appCompatActivity;

    public BackButton(String returnMessage, AppCompatActivity appCompatActivity){
        this.returnMessage = returnMessage;
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public void onClick(View view){
        Intent goBack = new Intent();
        goBack.putExtra(MainActivity.INTENT_RESULT_ACTIVITY_MAIN, returnMessage);
        appCompatActivity.setResult(appCompatActivity.RESULT_OK, goBack);
        appCompatActivity.finish();
    }

}
