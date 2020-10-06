package com.ayros.painter.shapes

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.shapes.OvalShape
import android.os.Build
import androidx.annotation.RequiresApi

class OvalShape(canvas: Canvas? = null, color: Int = Color.BLACK) : Shape(canvas, color) {
    
    var x1 = 0f
    var x2 = 0f
    var y1 = 0f
    var y2 = 0f

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun draw() {
        canvas?.drawOval(x1,y1,x2,y2,paint)
    }

    override fun startDrawing(x: Float, y: Float) {
        x1 = x
        x2 = x
        y1 = y
        y2 = y
    }

    override fun endDrawing(x: Float, y: Float) {
        x2 = x
        y2 = y
    }
}