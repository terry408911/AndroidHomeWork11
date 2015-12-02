package com.terry.nmy11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by terry on 12/1/15.
 */
public class Show extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);

        TextView title = (TextView) findViewById(R.id.textView2);
        TextView content = (TextView) findViewById(R.id.textView3);

        Intent intent = getIntent();
//        String titleText = intent.getStringExtra("title");
//        String contentText = intent.getStringExtra("content");
        title.setText(title.getText().toString()+intent.getStringExtra("title"));
        content.setText(content.getText().toString()+intent.getStringExtra("content"));
    }
}
