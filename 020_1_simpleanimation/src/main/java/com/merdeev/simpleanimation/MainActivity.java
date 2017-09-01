package com.merdeev.simpleanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);

        tv.setOnCreateContextMenuListener(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        switch(v.getId()) {
            case (R.id.tv):
                getMenuInflater().inflate(R.menu.mymenu,menu);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Animation anim = null;
        switch(item.getItemId()) {
            case(R.id.menu_alpha):
                anim = AnimationUtils.loadAnimation(this,R.anim.myalpha);
                break;
            case(R.id.menu_scale):
                anim = AnimationUtils.loadAnimation(this,R.anim.myscale);
                break;
            case(R.id.menu_translate):
                anim = AnimationUtils.loadAnimation(this,R.anim.mytrans);
                break;
            case(R.id.menu_rotate):
                anim = AnimationUtils.loadAnimation(this,R.anim.myrotate);
                break;
            case(R.id.menu_combo):
                anim = AnimationUtils.loadAnimation(this,R.anim.mycombo);
                break;
        }
        tv.startAnimation(anim);
        return super.onContextItemSelected(item);
    }
}
