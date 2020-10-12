package com.ayros.painter.shapes

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF
import android.graphics.drawable.shapes.OvalShape
import android.os.Build
import androidx.annotation.RequiresApi

class OvalShape(canvas: Canvas? = null, color: Int = Color.BLACK) : Shape(canvas, color) {

    lateinit var rect : RectF

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun draw() {
        rect = RectF(x1,y1,x2,y2)
        canvas?.drawOval(x1,y1,x2,y2,paint)
    }

}