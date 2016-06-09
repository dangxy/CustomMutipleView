package com.dxy.custommutipleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dxy.custommutipleview.bean.PieData;
import com.dxy.custommutipleview.view.PieView;

import java.util.ArrayList;

public class BaseGraphicsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_graphics);

        initData();
    }

    private void  initData(){

        PieView pieView =(PieView) findViewById(R.id.pie_view);

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
