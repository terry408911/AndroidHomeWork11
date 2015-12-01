package com.terry.nmy11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by terry on 12/1/15.
 */
public class Show extends Activity {
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.show);
        TextView title = (TextView) findViewById(R.id.textView);
        TextView content = (TextView) findViewById(R.id.editText2);

        Intent intent = getIntent();
        title.setText(title.getText()+intent.getStringExtra("title"));
        content.setText(content.getText()+intent.getStringExtra("content"));
    }
}
