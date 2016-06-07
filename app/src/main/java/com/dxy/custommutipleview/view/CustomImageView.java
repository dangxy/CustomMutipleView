package com.dxy.custommutipleview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.dxy.custommutipleview.R;

/**
 * Created by author_dang on 16/6/6.
 */
public class CustomImageView extends View {

    private String mTitleText;
    private int mTitleTextColor;
    private int mTitleTextSize;


    private Paint mPaint;
    private Rect mRect;
    private Bitmap mBitmap;
    private int mImageSacle;
    private Rect mTextBound;

    private int mWidth;

    private int mHeight;

    public CustomImageView(Context context) {
        this(context, null);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomImageView, defStyleAttr, 0);

        int n = typedArray.getIndexCount();

        for (int i = 0; i < n; i++) {
            int attr = typedArray.getIndex(i);
            switch (attr) {
                case R.styleable.CustomImageView_image:
                    mBitmap = BitmapFactory.decodeResource(getResources(), typedArray.getResourceId(attr, 0));
                    break;
                case R.styleable.CustomImageView_imageScaleType:
                    mImageSacle = typedArray.getInt(attr, 0);
                    break;

                case R.styleable.CustomImageView_title_text_color:
                    mTitleTextColor = typedArray.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.CustomImageView_title_text:
                    mTitleText = typedArray.getString(attr);
                    break;
                case R.styleable.CustomImageView_title_text_size:
                    mTitleTextSize = typedArray.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));

                    break;
            }
        }

        typedArray.recycle();
        mRect = new Rect();

        mPaint = new Paint();
        mTextBound = new Rect();
        mPaint.setTextSize(mTitleTextSize);

        mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mTextBound);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            mWidth=specSize;
        }else{
            int desireByImage = getPaddingLeft()+getPaddingRight()+mBitmap.getWidth();

            int desireByTitle = getPaddingLeft()+getPaddingRight()+mTextBound.width();

            if(specMode==MeasureSpec.AT_MOST){
                mWidth = Math.min(desireByImage,desireByTitle);
            }
        }

        specMode= MeasureSpec.getMode(heightMeasureSpec);
        specSize= MeasureSpec.getSize(heightMeasureSpec);


        if(specMode==MeasureSpec.EXACTLY){
            mHeight= specSize;
        }else {
            int desire = getPaddingTop()+getPaddingBottom()+mBitmap.getHeight()+mTextBound.height();

            if(specMode==MeasureSpec.AT_MOST){
                mHeight= Math.min(specSize,desire);
            }
        }

       setMeasuredDimension(mWidth,mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setStrokeWidth(4);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.CYAN);

        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint);


        mRect.left=getPaddingLeft();

        mRect.right= mWidth-getPaddingRight();

        mRect.top = getPaddingTop();

        mRect.bottom= mHeight-getPaddingBottom();

        mPaint.setColor(mTitleTextColor);

        mPaint.setStyle(Paint.Style.FILL);


        if(mTextBound.width()>mWidth){
            TextPaint paint = new TextPaint(mPaint);
            String msg = TextUtils.ellipsize(mTitleText, paint, (float) mWidth - getPaddingLeft() - getPaddingRight(),
                    TextUtils.TruncateAt.END).toString();
            canvas.drawText(msg, getPaddingLeft(), mHeight - getPaddingBottom(), mPaint);

        }else{
            //正常情况，将字体居中
            canvas.drawText(mTitleText, mWidth / 2 - mTextBound.width() * 1.0f / 2, mHeight - getPaddingBottom(), mPaint);
        }

        //取消使用掉的快
        mRect.bottom -= mTextBound.height();

        if (mImageSacle == 0)
        {
            canvas.drawBitmap(mBitmap, null, mRect, mPaint);
        } else
        {
            //计算居中的矩形范围
            mRect.left = mWidth / 2 - mBitmap.getWidth() / 2;
            mRect.right = mWidth / 2 + mBitmap.getWidth() / 2;
            mRect.top = (mHeight - mTextBound.height()) / 2 - mBitmap.getHeight() / 2;
            mRect.bottom = (mHeight - mTextBound.height()) / 2 + mBitmap.getHeight() / 2;

            canvas.drawBitmap(mBitmap, null, mRect, mPaint);
        }
    }
}
