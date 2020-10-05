package com.ayros.painter.shapes

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Path
import android.util.Log
import android.view.SurfaceHolder

class PathShape(canvas: Canvas? = null, color: Int = Color.BLACK) : Shape(canvas, color) {

    val path = Path()

    override fun startDrawing(x: Float, y: Float) {
        Log.d("drawing", "x = $x, y = $y ")
        path.moveTo(x, y)
    }

    override fun endDrawing(x: Float, y: Float) {
        path.lineTo(x, y)
    }

    override fun draw() {
        canvas?.drawPath(path,paint)
    }
}