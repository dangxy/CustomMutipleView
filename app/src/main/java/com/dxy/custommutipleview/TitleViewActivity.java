package com.dxy.custommutipleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dxy.custommutipleview.bean.PieData;
import com.dxy.custommutipleview.view.PieView;
import com.dxy.custommutipleview.view.TitleView;

import java.util.ArrayList;

public class TitleViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_view);

        initView();



    }

    private void initView(){

       TitleView titleView = (TitleView) findViewById(R.id.tv_title);

        PieView pieView =(PieView) findViewById(R.id.pie_view);

        titleView.setTitleText("这是标题文件");

        titleView.setButtonView("返回键");

        titleView.setOnBackClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ArrayList<PieData> arrayList = new ArrayList<>();

        arrayList.add(new PieData("第一份",10));
        arrayList.add(new PieData("第二份",15));
        arrayList.add(new PieData("第三份",20));
        arrayList.add(new PieData("第四份",25));
        arrayList.add(new PieData("第五份",30));

        pieView.setData(arrayList);
        pieView.setstartAngle(-90);
    }
}
