package com.merdeev.intentfilter;

import android.content.Intent;
import android.os.Trace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button btnTime, btnDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDate = (Button) findViewById(R.id.btnDate);
        btnTime = (Button) findViewById(R.id.btnTime);

        btnTime.setOnClickListener(this);
        btnDate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case (R.id.btnTime):
                intent = new Intent("com.merdeev.intent.action.showtime");
                startActivity(intent);
                break;

            case (R.id.btnDate):
                intent = new Intent("com.merdeev.intent.action.showdate");
                startActivity(intent);
                break;
        }
    }
}
