package com.merdeev.dynamiclayout2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout llMain;
    RadioGroup rgGravity;
    EditText etName;
    Button btnCreate;
    Button btnClear;


    final int WRAP_CONTENT = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llMain = (LinearLayout) findViewById(R.id.llMain);
        rgGravity = (RadioGroup) findViewById(R.id.rgGravity);
        etName = (EditText) findViewById(R.id.etName);

        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnClear = (Button) findViewById(R.id.btnClear);
    }

    void onClickButton(View v) {
        switch(v.getId()) {
            case (R.id.btnCreate):
                // Создание LayoutParams c шириной и высотой по содержимому
                LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
                        WRAP_CONTENT, WRAP_CONTENT);
                // переменная для хранения значения выравнивания
                // по умолчанию пусть будет LEFT
                int btnGravity = Gravity.LEFT;
                // определяем, какой RadioButton "чекнут" и
                // соответственно заполняем btnGravity
                switch (rgGravity.getCheckedRadioButtonId()) {
                    case R.id.rbLeft:
                        btnGravity = Gravity.LEFT;
                        break;
                    case R.id.rbCenter:
                        btnGravity = Gravity.CENTER_HORIZONTAL;
                        break;
                    case R.id.rbRight:
                        btnGravity = Gravity.RIGHT;
                        break;
                }
                // переносим полученное значение выравнивания в LayoutParams
                lParams.gravity = btnGravity;

                // создаем Button, пишем текст и добавляем в LinearLayout
                Button btnNew = new Button(this);
                btnNew.setText(etName.getText().toString());
                llMain.addView(btnNew, lParams);
                break;

            case (R.id.btnClear):
                llMain.removeAllViews();
                Toast.makeText(this,"Удалено",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
