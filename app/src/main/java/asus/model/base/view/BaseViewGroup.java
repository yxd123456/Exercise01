package asus.model.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;

import io.sweers.barber.Barber;

/**
 * Created by asus on 2016/7/22.
 */
public class BaseViewGroup extends ViewGroup {

    private BasePaint paint;
    protected Context context;

    public BaseViewGroup(Context context) {

        this(context, null, 0);
    }

    public BaseViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Barber.style(this, attrs, getAttrs(), defStyleAttr);
        this.context = context;
        init();
    }

    int width = 0;
    int height = 0;
    int modeWidth;
    int modeHeight;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        onMeasure_(widthMeasureSpec, heightMeasureSpec);

        if(modeWidth == MeasureSpec.EXACTLY){
            width = sizeWidth;
        }
        if(modeHeight == MeasureSpec.EXACTLY){
            height = sizeHeight;
        }
        if(modeWidth == MeasureSpec.AT_MOST){
            width = getAtMostWidth();
        }
        if(modeHeight == MeasureSpec.AT_MOST ){
            height = getAtMostHeight();
        }
        setMeasuredDimension(width, height);

    }

    protected void onMeasure_(int widthMeasureSpec, int heightMeasureSpec) {
    }


    protected int getAtMostHeight() {
        return 0;
    }

    protected int getAtMostWidth() {
        return 0;
    }


    public interface OnMeasureAtMost{
        void getAtMostWidth();
        void getAtMostHeight();
    }


    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }

    protected void init() {
    }

    protected int[] getAttrs() {
        return new int[0];
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new BasePaint();
        onDraw(canvas, paint);
    }

    protected void onDraw(Canvas canvas, BasePaint paint) {
    }


}
