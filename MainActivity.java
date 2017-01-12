package com.example.hui;

import android.app.AlertDialog;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.support.v4.app.NotificationCompat;


public class MainActivity extends Activity {
	 	@Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);  
	         
	        Button btn1 = (Button)findViewById(R.id.button1);
	        btn1.setOnClickListener(new OnClickListener(){
 

				 ///@SuppressWarnings("deprecation")
				@Override
				public void onClick(View v) {
					 
					Intent intent = new Intent(Intent.ACTION_DIAL);
					startActivity(intent);
					
					
					Intent launchIntent = new Intent(MainActivity.this, MainActivity.class)
					.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
							| Intent.FLAG_ACTIVITY_SINGLE_TOP);
					((NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE)).notify(
					0,
					new NotificationCompat.Builder(MainActivity.this)
							.setDefaults(Notification.DEFAULT_ALL)
							.setWhen(System.currentTimeMillis())
							.setSmallIcon(R.drawable.ic_launcher)
							.setTicker("Test Ticker")
							.setContentTitle("Test Title")
							.setContentText("Test ContentText")
							.setContentIntent(
									PendingIntent.getActivity(MainActivity.this, 0,
											launchIntent, 0)).setAutoCancel(true)
							.build());
					/*
					AlertDialog.Builder d = new AlertDialog.Builder(MainActivity.this);
					d.setTitle("This is title");
					d.setMessage("This is message.");
					d.setPositiveButton("确定", null);
					d.show();*/
					
					
				}
	        	
	        	
	        });
	    }
 
}
