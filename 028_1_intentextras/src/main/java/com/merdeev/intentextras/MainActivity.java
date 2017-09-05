package com.merdeev.intentextras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    EditText etFName, etLName;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);

        etFName = (EditText) findViewById(R.id.etFName);
        etLName = (EditText) findViewById(R.id.etLName);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case(R.id.btnSubmit):
                Intent intent = new Intent(this, ViewActivity.class);
                intent.putExtra("fname",etFName.getText().toString());
                intent.putExtra("lname",etLName.getText().toString());
                startActivity(intent);
                break;
        }
    }
}
