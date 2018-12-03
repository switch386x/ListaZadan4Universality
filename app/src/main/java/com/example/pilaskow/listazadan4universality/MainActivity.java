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
    @Override
    public void onPause(){
        super.onPause();
        // jak zrobic zeby to mialo dostep do mojego edit texta i jak nie zamykam appki tylko ja minimalizuje i wznawiam z notyfikacji zeby maintainowalo text a kiedy ja zamykam i odpalam
        // z notyfikacji to zeby sie nie maintainowal stan editText
    }
    @Override
    public void onResume(){
        super.onResume();

    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void sendNotification(View view){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this); //czemu to jest deprecated(redundant code)
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentTitle("Hello");
        builder.setContentText("Click me too!");

        Intent resultIntent = new Intent(this,MainActivity.class);
        TaskStackBuilder sb = create(this);
        sb.addParentStack(MainActivity.class);
        sb.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = sb.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
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
