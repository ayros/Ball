package com.ayros.painter.shapes

import android.graphics.Canvas
import android.graphics.Color
import kotlin.math.sqrt

class CircleShape(canvas: Canvas? = null, color: Int = Color.WHITE) :
    Shape(canvas, color) {

    var x1 = 0f
    var y1 = 0f
    var r = 0f

    var vector_x = 0f
    var vector_y = 0f

    override fun draw() {
        if (canvas!=null){
            canvas?.drawCircle(x1 + vector_x/2, y1 + vector_y/2, r, paint)
        }
    }

    override fun startDrawing(x: Float, y: Float) {
        x1 = x
        y1 = y
        r = 0f
    }

    override fun endDrawing(x: Float, y: Float) {
        r = sqrt((x - x1) *(x - x1) + (y - y1)*(y - y1))/2
        vector_x = x - x1
        vector_y = y - y1
    }
}