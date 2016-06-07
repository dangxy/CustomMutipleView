package com.dxy.custommutipleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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

        titleView.setTitleText("这是标题文件");

        titleView.setButtonView("返回键");

        titleView.setOnBackClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
