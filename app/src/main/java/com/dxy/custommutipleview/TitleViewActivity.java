package com.dxy.custommutipleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dxy.custommutipleview.view.TitleView;

public class TitleViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_view);

        initView();



    }

    private void initView(){

       TitleView titleView = (TitleView) findViewById(R.id.tv_title);


    }
}
