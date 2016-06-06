package com.dxy.custommutipleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

    }
}
