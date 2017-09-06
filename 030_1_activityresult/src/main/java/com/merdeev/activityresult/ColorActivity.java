package com.merdeev.activityresult;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ColorActivity extends AppCompatActivity implements OnClickListener{

    Button btnRed, btnGreen, btnBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        btnRed = (Button) findViewById(R.id.btnRed);
        btnRed.setOnClickListener(this);

        btnGreen = (Button) findViewById(R.id.btnGreen);
        btnGreen.setOnClickListener(this);

        btnBlue = (Button) findViewById(R.id.btnBlue);
        btnBlue.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch(view.getId()) {
            case (R.id.btnRed):
                intent.putExtra("color", Color.RED);
                break;

            case (R.id.btnGreen):
                intent.putExtra("color", Color.GREEN);
                break;

            case (R.id.btnBlue):
                intent.putExtra("color", Color.BLUE);
                break;
        }
        setResult(RESULT_OK,intent);
        finish();
    }
}
