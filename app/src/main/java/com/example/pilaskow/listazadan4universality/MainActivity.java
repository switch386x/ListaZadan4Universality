package com.example.pilaskow.listazadan4universality;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

import static android.app.TaskStackBuilder.create;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button clickmebtn = findViewById(R.id.ClickMeBtn);
        final EditText testEditText = findViewById(R.id.plainText);
        clickmebtn.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                sendNotification(v);
            }
            });

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void sendNotification(View view){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this); //deprecated - przestarzaly kod, dzialajacy ale trzymany ze wzgledu na wsteczkompatybilnosc
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentTitle("Hello");
        builder.setContentText("Click me too!");
        builder.setAutoCancel(true);
        Intent resultIntent = new Intent(this,MainActivity.class);
        resultIntent.setAction(Intent.ACTION_MAIN);
        resultIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        resultIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
//        TaskStackBuilder sb = create(this);
//        sb.addParentStack(MainActivity.class);
//        sb.addNextIntent(resultIntent);
//        PendingIntent resultPendingIntent = sb.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 0, resultIntent, 0);
        builder.setContentIntent(resultPendingIntent);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(001,builder.build());
    }

  /* public void manageState(View view){
        Intent notificationIntent = new Intent(this,MainActivity.class);
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent contentIntent = PendingIntent.getActivity(this,0,notificationIntent,0);
    }
*/
}
