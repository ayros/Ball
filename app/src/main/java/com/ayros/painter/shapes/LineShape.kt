package com.ayros.painter.shapes

import android.graphics.Canvas
import android.graphics.Color

class LineShape(canvas: Canvas? = null, color: Int = Color.BLACK) : Shape(canvas, color) {

    var x0 = 0f
    var y0 = 0f
    var x1 = 0f
    var y1 = 0f

    override fun draw() {
        canvas?.drawLine(x0,y0,x1,y1,paint)
    }

    override fun startDrawing(x: Float, y: Float) {
        x0 = x
        y0 = y
        x1 = x
        y1 = y
    }

    override fun endDrawing(x: Float, y: Float) {
        x1 = x
        y1 = y
    }
}