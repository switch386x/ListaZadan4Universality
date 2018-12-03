package com.example.pilaskow.listazadan4universality;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button clickmebtn = findViewById(R.id.ClickMeBtn);
        clickmebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification(v);
            }
            });
    }
    public void sendNotification(View view){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this); //czemu to jest deprecated(redundant code)
        builder.setSmallIcon(R.drawable.ic_launcher_foreground);
        builder.setContentTitle("Hello");
        builder.setContentText("Click me too!");

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(001,builder.build());
    }

}
