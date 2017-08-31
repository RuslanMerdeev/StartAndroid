package com.merdeev.contextmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvColor, tvSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find views
        tvColor = (TextView) findViewById(R.id.tvColor);
        tvSize = (TextView) findViewById(R.id.tvSize);

        tvColor.setOnCreateContextMenuListener(this);
        tvSize.setOnCreateContextMenuListener(this);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()){
            case R.id.tvColor:
                getMenuInflater().inflate(R.menu.colormenu, menu);
                break;

            case R.id.tvSize:
                getMenuInflater().inflate(R.menu.sizemenu, menu);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_color_red:
                tvColor.setTextColor(Color.RED);
                tvColor.setText("Text color = red");
                break;
            case R.id.menu_color_green:
                tvColor.setTextColor(Color.GREEN);
                tvColor.setText("Text color = green");
                break;
            case R.id.menu_color_blue:
                tvColor.setTextColor(Color.BLUE);
                tvColor.setText("Text color = blue");
                break;
// пункты меню для tvSize
            case R.id.menu_size_22:
                tvSize.setTextSize(22);
                tvSize.setText("Text size = 22");
                break;
            case R.id.menu_size_26:
                tvSize.setTextSize(26);
                tvSize.setText("Text size = 26");
                break;
            case R.id.menu_size_30:
                tvSize.setTextSize(30);
                tvSize.setText("Text size = 30");
                break;
        }
        return super.onContextItemSelected(item);
    }


}
