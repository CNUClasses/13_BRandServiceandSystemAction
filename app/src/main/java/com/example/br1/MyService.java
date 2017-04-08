package com.example.br1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service{

	private static final String TAG = "BRandServiceandSystemAction";
	private static final int TWO_SECONDS = 2000;

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Toast.makeText(this, "In Service", Toast.LENGTH_SHORT).show();
		doagain();

		stopSelf();
		return 0;
	}

	void doagain(){
		Intent startIntent = new Intent("com.example.br1.MYACTION");
		PendingIntent startPIntent = PendingIntent.getBroadcast(this, 0, startIntent, 0);
		AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
		alarm.set(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime() + + TWO_SECONDS, startPIntent);
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
