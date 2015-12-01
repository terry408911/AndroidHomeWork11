package com.terry.nmy11;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

/**
 * Created by terry on 12/1/15.
 */
public class MyService extends Service {
    MyBroadcastReceiver myBroadcastReceiver;
    Intent intent;
    String title = null;
    String content = null;
    @Override
    public IBinder onBind(Intent intent){

        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();

        //receive broadcast
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.terry.nmy11.MESSAGE");
        myBroadcastReceiver = new MyBroadcastReceiver();
        registerReceiver(myBroadcastReceiver,intentFilter);

        //sent broadcast
        intent.setAction("com.terry.nmy11.MESSAGE");
        intent.putExtra("title", title );
        intent.putExtra("content",content);
        sendBroadcast(intent);
    }

    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        unregisterReceiver(myBroadcastReceiver);
    }
}