package com.merdeev.simpleactivityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    Button btnName;
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnName = (Button) findViewById(R.id.btnName);
        btnName.setOnClickListener(this);

        tvName = (TextView) findViewById(R.id.tvName);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case (R.id.btnName):
                Intent intent = new Intent(this,NameActivity.class);
                startActivityForResult(intent,1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data==null) return;
        String name = data.getStringExtra("name");
        tvName.setText("Your name is " + name);
    }
}
