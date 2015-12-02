package com.terry.nmy11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button send;
    EditText title;
    EditText content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send = (Button) findViewById(R.id.button);
        title = (EditText) findViewById(R.id.editText);
        content = (EditText) findViewById(R.id.editText2);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startIntent = new Intent(MainActivity.this,MyService.class);
                startIntent.putExtra("title",title.getText().toString());
                startIntent.putExtra("content",content.getText().toString());
                startService(startIntent);

            }
        });

    }



}
