package com.ayros.painter.shapes

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.SurfaceHolder

abstract class Shape(val color: Int = Color.WHITE){

    lateinit var canvas: Canvas
    val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    init {
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 3f
        paint.color = color
    }

    abstract fun draw()

    abstract fun startDrawing(x: Float, y: Float)

    abstract fun endDrawing(x: Float, y: Float)


}