package com.ayros.ball.shapes

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

abstract class Shape(var canvas: Canvas? = null,val color: Int = Color.BLACK){

    val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    var x1 = 0f
    var x2 = 0f
    var y1 = 0f
    var y2 = 0f

    init {
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.strokeWidth = 3f
        paint.color = color
    }

    abstract fun draw()

    open fun startDrawing(x: Float, y: Float){
        x1 = x
        y1 = y
        x2 = x
        y2 = y
    }

   open fun endDrawing(x: Float, y: Float){
       x2 = x
       y2 = y
   }


}