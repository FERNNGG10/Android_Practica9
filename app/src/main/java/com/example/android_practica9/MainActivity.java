package com.example.android_practica9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.Manifest;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView seconds;
    private String[] permissionsToCheck = {
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.CALL_PHONE
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seconds = (TextView) findViewById(R.id.seconds);
        new CountDownTimer(5200,1000){

            @Override
            public void onTick(long l) {
                seconds.setText(""+l/1000);
            }

            @Override
            public void onFinish() {
                boolean allPermissionsGranted = checkAllPermissionsGranted();
                if(!allPermissionsGranted){
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                    startActivity(intent);
                }

            }
        }.start();
    }
    private boolean checkAllPermissionsGranted() {
        for (String permission : permissionsToCheck) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }
}