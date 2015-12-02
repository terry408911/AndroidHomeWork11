package com.terry.nmy11;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by terry on 12/1/15.
 */
public class MyService extends Service {
    MyBroadcastReceiver myBroadcastReceiver;
    String title = "123";
    String content = "456";

    @Override
    public IBinder onBind(Intent intent){

        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();

        Log.d("test","123");
    }

    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        //register broadcast receiver
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.terry.nmy11.MESSAGE");
        myBroadcastReceiver = new MyBroadcastReceiver();
        registerReceiver(myBroadcastReceiver, intentFilter);

        Log.d("test", "fuck Android");
        this.title = intent.getStringExtra("title");
        Log.d("title",title);
        this.content = intent.getStringExtra("content");

        Log.d("content",content);

        send();

        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        unregisterReceiver(myBroadcastReceiver);
    }

    public void send(){
        Intent intent1 = new Intent();
        intent1.setAction("com.terry.nmy11.MESSAGE");
        intent1.putExtra("title", title);
        intent1.putExtra("content", content);
        sendBroadcast(intent1);
    }
}
