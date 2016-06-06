package com.dxy.custommutipleview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.dxy.custommutipleview.R;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by author_dang on 16/6/6.
 */
public class TitleTextView extends View {

    private String mTitleText;
    private int mTitleTextColor;
    private int mTitleTextSize;

    private Paint mPaint;
    private Rect mRect;

    public TitleTextView(Context context) {
        this(context, null);
    }

    public TitleTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleTextView, defStyleAttr, 0);

        int n = typedArray.getIndexCount();

        for (int i = 0; i < n; i++) {


            int attr = typedArray.getIndex(i);

            switch (attr) {

                case R.styleable.TitleTextView_title_text:

                    mTitleText = typedArray.getString(attr);
                    break;

                case R.styleable.TitleTextView_title_text_color:
                    mTitleTextColor = typedArray.getColor(attr, Color.BLACK);

                    break;
                case R.styleable.TitleTextView_title_text_size:

                    mTitleTextSize = typedArray.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));


                    break;
            }


        }

        typedArray.recycle();

        mPaint = new Paint();
        mPaint.setTextSize(mTitleTextSize);
        mPaint.setColor(mTitleTextColor);
        mRect = new Rect();
        mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mRect);


        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mTitleText = randomText();
                postInvalidate();
            }
        });
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {


        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int heightSize = MeasureSpec.getSize(heightMeasureSpec);


        int width;
        int height;

        if (widthMode == MeasureSpec.EXACTLY) {

            width = widthSize;
        } else {
            mPaint.setTextSize(mTitleTextSize);
            mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mRect);

            float textWidth = mRect.width();

            int desired = (int) (getPaddingRight() + textWidth + getPaddingLeft());

            width = desired;
        }


        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            mPaint.setTextSize(mTitleTextSize);

            mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mRect);

            float textHeight = mRect.height();

            int desired = (int) (getPaddingTop() + textHeight + getPaddingBottom());
            height = desired;
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        mPaint.setColor(Color.YELLOW);

        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);

        mPaint.setColor(mTitleTextColor);

        canvas.drawText(mTitleText, getWidth() / 2 - mRect.width() / 2, getHeight() / 2 + mRect.height() / 2, mPaint);

    }

    private String randomText() {

        Random random = new Random();
        Set<Integer> set = new HashSet<Integer>();
        while (set.size() < 6)
        {
            int randomInt = random.nextInt(10);
            set.add(randomInt);
        }
        StringBuffer sb = new StringBuffer();
        for (Integer i : set)
        {
            sb.append("" + i);
        }

        return sb.toString();
    }
}
