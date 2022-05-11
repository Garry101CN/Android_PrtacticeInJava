package com.garroid.androidadvancejava

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.icu.util.Measure
import android.util.AttributeSet
import android.view.View

class RectView : View {

    private var mPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var mColor: Int = Color.RED

    constructor(context: Context) : super(context) {
        initDraw()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs){
        val mTypedArray : TypedArray = context.obtainStyledAttributes(attrs, R.styleable.RectView)
        mColor = mTypedArray.getColor(R.styleable.RectView_rect_color, Color.RED)
        mTypedArray.recycle()
        initDraw()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        initDraw()
    }

    private fun initDraw(){
        mPaint.color = mColor
        mPaint.strokeWidth = 1.5F
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paddingLeft: Float = paddingLeft.toFloat()
        val paddingRight: Float = paddingRight.toFloat()
        val paddingTop: Float = paddingTop.toFloat()
        val paddingBottom: Float = paddingBottom.toFloat()

        val width:Float = width.toFloat() - paddingLeft - paddingRight
        val height:Float = height.toFloat() - paddingTop - paddingBottom
        canvas?.drawRect(0F + paddingLeft,0F + paddingTop, width + paddingLeft, height + paddingTop, mPaint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthSpecMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightSpecMode = MeasureSpec.getMode(heightMeasureSpec)
        val widthSpecSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSpecSize = MeasureSpec.getSize(heightMeasureSpec)

        if(widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(600, 600);
        }else if(widthMeasureSpec == MeasureSpec.AT_MOST){
            setMeasuredDimension(600, heightSpecSize)
        }else if(heightMeasureSpec == MeasureSpec.AT_MOST){
            setMeasuredDimension(widthMeasureSpec, 600)
        }
    }

}