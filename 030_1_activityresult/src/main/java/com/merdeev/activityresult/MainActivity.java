package com.merdeev.activityresult;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    TextView tvText;
    Button btnColor, btnAlign;
    final int REQUEST_CODE_COLOR = 1;
    final int REQUEST_CODE_ALIGN = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvText = (TextView) findViewById(R.id.tvText);

        btnColor = (Button) findViewById(R.id.btnColor);
        btnColor.setOnClickListener(this);

        btnAlign = (Button) findViewById(R.id.btnAlign);
        btnAlign.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch(view.getId()) {
            case (R.id.btnColor):
                intent = new Intent(this,ColorActivity.class);
                startActivityForResult(intent,REQUEST_CODE_COLOR);
                break;

            case (R.id.btnAlign):
                intent = new Intent(this,AlignActivity.class);
                startActivityForResult(intent,REQUEST_CODE_ALIGN);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("States", "requestCode = " + requestCode + ", resultCode = " + resultCode);
        if(resultCode == RESULT_OK) {
            switch (requestCode) {
                case (REQUEST_CODE_COLOR):
                    tvText.setTextColor(data.getIntExtra("color", Color.WHITE));
                    break;

                case (REQUEST_CODE_ALIGN):
                    tvText.setGravity(data.getIntExtra("alignment", Gravity.LEFT));
                    break;
            }
        }
        else {
            Toast.makeText(this,"Wrong result",Toast.LENGTH_SHORT).show();
        }
    }
}
