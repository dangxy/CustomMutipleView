package com.dxy.custommutipleview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.dxy.custommutipleview.bean.PieData;

import java.util.ArrayList;

/**
 * Created by author_dang on 16/6/9.
 */
public class PieView extends View {
    // 颜色表
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};

    private float mStartAngle = 0;

    private ArrayList<PieData> mData;

    private int mWidth,mHeigth;

    private Paint mPaint;


    public PieView(Context context) {
        this(context,null);
    }

    public PieView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint(){

        mPaint = new Paint();

        mPaint.setStyle(Paint.Style.FILL);

        mPaint.setAntiAlias(true);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth=w;

        mHeigth=h;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(null==mData){
            return;
        }

        float currentStartAngle = mStartAngle;

        canvas.translate(mWidth/2,mHeigth/2);

        float r = (float)(Math.min(mWidth,mHeigth)/2*0.8);


        RectF rectF =new RectF(-r,-r,r,r);

        for(int i= 0 ;i<mData.size();i++){
            PieData pie = mData.get(i);

            mPaint.setColor(pie.getColor());

            canvas.drawArc(rectF,currentStartAngle,pie.getAngle(),true,mPaint);
            currentStartAngle+=pie.getAngle();
        }
    }

    public void setstartAngle(int mstartAngle){
        this.mStartAngle = mstartAngle;
        invalidate();
    }

    public void setData(ArrayList<PieData> mData){
        this.mData = mData;

        initData(mData);

        invalidate();
    }

    public  void initData(ArrayList<PieData> mData){
        if (null == mData || mData.size() == 0)
            return;

        float sumValue = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieData pie = mData.get(i);

            sumValue += pie.getValue();       //计算数值和

            int j = i % mColors.length;       //设置颜色
            pie.setColor(mColors[j]);
        }

        float sumAngle = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieData pie = mData.get(i);

            float percentage = pie.getValue() / sumValue;   // 百分比
            float angle = percentage * 360;                 // 对应的角度

            pie.setPercentage(percentage);                  // 记录百分比
            pie.setAngle(angle);                            // 记录角度大小
            sumAngle += angle;

            Log.i("angle", "" + pie.getAngle());
        }

    }
}
