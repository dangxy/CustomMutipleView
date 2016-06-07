package com.dxy.custommutipleview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dxy.custommutipleview.view.TitleTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }
    private void  initView(){
       TitleTextView titleTextView = (TitleTextView) findViewById(R.id.tv_title_view);

        findViewById(R.id.bt_title_view_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TitleViewActivity.class);
                startActivity(intent);
            }
        });

    }
}
