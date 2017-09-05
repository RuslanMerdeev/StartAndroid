package com.merdeev.simpleactivityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity implements OnClickListener{

    Button btnOK;
    EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        btnOK = (Button) findViewById(R.id.btnOK);
        btnOK.setOnClickListener(this);

        etName = (EditText) findViewById(R.id.etName);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case (R.id.btnOK):
                Intent intent = new Intent();
                intent.putExtra("name",etName.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
                break;
        }
    }
}
