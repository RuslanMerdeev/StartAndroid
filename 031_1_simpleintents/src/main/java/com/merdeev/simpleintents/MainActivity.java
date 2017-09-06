package com.merdeev.simpleintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    Button btnWeb, btnMap, btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWeb = (Button) findViewById(R.id.btnWeb);
        btnMap = (Button) findViewById(R.id.btnMap);
        btnCall = (Button) findViewById(R.id.btnCall);

        btnWeb.setOnClickListener(this);
        btnMap.setOnClickListener(this);
        btnCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //Intent intent;
        switch(view.getId()){
            case(R.id.btnWeb):
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com"));
                startActivity(intent);
                break;
            case(R.id.btnMap):
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:55.754283,37.62002"));
                startActivity(intent);
                break;
            case(R.id.btnCall):
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:12345"));
                startActivity(intent);
                break;
        }
    }
}
