package com.dxy.custommutipleview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by author_dang on 16/6/9.
 */
public class BaseGraphics extends View {

    private Paint mPaint;

    public BaseGraphics(Context context) {
        this(context,null);
    }

    public BaseGraphics(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BaseGraphics(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initData();
    }

    private void initData(){

        mPaint = new Paint();

        mPaint.setColor(Color.BLUE);

        mPaint.setStyle(Paint.Style.FILL);

        mPaint.setStrokeWidth(10);

    }

    @Override
    protected void onDraw(Canvas canvas) {


       // canvas.drawPoint(200,200,mPaint);

       // canvas.drawPoints(new float[]{500,500,600,600,700,700},mPaint);


        //canvas.drawLine(300,300,500,600,mPaint);

        //canvas.drawLines(new float[]{100,200,200,200,100,300,200,300},mPaint);


        //canvas.drawRect(100,100,800,400,mPaint);


        RectF rectF = new RectF(100,100,800,400);

        //canvas.drawRoundRect(rectF,30,30,mPaint);

//        mPaint.setColor(Color.GRAY);
//
//        canvas.drawRect(rectF,mPaint);
//
//
//        mPaint.setColor(Color.BLUE);
//
//        canvas.drawRoundRect(rectF,700,400,mPaint);


       // canvas.drawOval(rectF,mPaint);



//


       // canvas.drawCircle(500,500,400,mPaint);




        mPaint.setColor(Color.BLACK);


        mPaint.setStrokeWidth(40);


        mPaint.setStyle(Paint.Style.STROKE);

       canvas.drawCircle(200,200,100,mPaint);


        mPaint.setStyle(Paint.Style.FILL);

        canvas.drawCircle(200,500,100,mPaint);

        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        canvas.drawCircle(200,800,100,mPaint);







    }
}
