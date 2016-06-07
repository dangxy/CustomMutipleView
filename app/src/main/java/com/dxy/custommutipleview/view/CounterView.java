package com.dxy.custommutipleview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by author_dang on 16/6/7.
 */
public class CounterView extends View  implements View.OnClickListener{


    private Paint mPaint;

    private Rect mBounds;

    private int mCount;

    public CounterView(Context context) {
        this(context, null);
    }

    public CounterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CounterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView();
    }

    private void initView() {


        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBounds = new Rect();

        setOnClickListener(this);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);

        mPaint.setColor(Color.BLUE);
        mPaint.setTextSize(30);

        String text = String.valueOf(mCount);

        mPaint.getTextBounds(text,0,text.length(),mBounds);

        float textWidth = mBounds.width();

        float textHeight = mBounds.height();

        canvas.drawText(text,getWidth()/2-textWidth/2,getHeight()/2-textHeight/2,mPaint);
    }

    @Override
    public void onClick(View v) {

        mCount++;
        invalidate();
    }
}
