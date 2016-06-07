package com.dxy.custommutipleview.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.dxy.custommutipleview.R;

/**
 * Created by author_dang on 16/6/7.
 */
public class TitleView extends FrameLayout {
   private  TextView textView;
    private Button back;
    public TitleView(Context context) {
        this(context,null);
    }

    public TitleView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

      View view =   LayoutInflater.from(context).inflate(R.layout.title_view,this);

       textView = (TextView) findViewById(R.id.tv_title_content);

         back = (Button) findViewById(R.id.bt_back);


        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();
            }
        });


    }

    public void setTitleText(String text){

        textView.setText(text);
    }

    public  void setButtonView(String text){
        back.setText(text);
    }

    public  void setOnBackClickListener(OnClickListener onClickListener){

        back.setOnClickListener(onClickListener);

    }
}
