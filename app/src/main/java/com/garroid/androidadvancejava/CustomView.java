package com.garroid.androidadvancejava;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;

import androidx.annotation.Nullable;

public class CustomView extends View {

    private int lastX;
    private int lastY;
    private Scroller mScroller;


    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public boolean onTouchEvent(MotionEvent event){
        // 获取手指触摸点的横坐标和纵坐标
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:{
                lastX = x;
                lastY = y;
                break;
            }
            case MotionEvent.ACTION_MOVE:{
                // 计算移动的距离
                int offsetX = x - lastX;
                int offsetY = y - lastY;

                // 调用layout方法来重新防止它的位置
                // 方法一
                // layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
                // 方法二
                // offsetLeftAndRight(offsetX);
                // offsetTopAndBottom(offsetY);

                // 方法三 LayoutParams
//                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
//                layoutParams.leftMargin = getLeft() + offsetX;
//                layoutParams.topMargin = getTop() + offsetY;
//                setLayoutParams(layoutParams);

                // 方法四 见MovableViewActivity
                // 方法五 scrollBy scrollTo 反向移动手机，画布静止不动
                ((View)getParent()).scrollBy(-offsetX, -offsetY);
                break;
            }
        }
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if(mScroller.computeScrollOffset()){
            ((View)getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }

    public void smoothScrollTo(int destX, int destY){
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int deltaX = destX - scrollX;
        int deltaY = destY - scrollY;
        mScroller.startScroll(scrollX, scrollY, deltaX, deltaY, 2000);
        invalidate();
    }
}
