package com.ayros.painter.shapes

import android.graphics.Canvas
import android.graphics.Color

class RectangleShape(canvas: Canvas? = null, color: Int = Color.BLACK) : Shape(canvas, color) {



    override fun draw() {
        canvas?.drawRect(x1,y1,x2,y2,paint)
    }
}