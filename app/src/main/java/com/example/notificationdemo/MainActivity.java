package com.example.notificationdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public final String CHANNEL_ID = "001";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showNotification(View view)
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,"001", NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("This is Description..");


            NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);;


            Notification.Builder builder = new Notification.Builder(this, CHANNEL_ID);
            builder.setSmallIcon(R.mipmap.ic_launcher)
                    .setContentText("New Message")
                    .setContentTitle("Hello There")
                    .setPriority(Notification.PRIORITY_DEFAULT);


            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
            notificationManagerCompat.notify(001,builder.build());

        }else
            {
                Notification.Builder builder = new Notification.Builder(this);
                builder.setSmallIcon(R.mipmap.ic_launcher)
                        .setContentText("New Message")
                        .setContentTitle("Your SDK Version is Less then 8(OREO)")
                        .setPriority(Notification.PRIORITY_DEFAULT);

                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
                notificationManagerCompat.notify(001,builder.build());

            }
    }
}