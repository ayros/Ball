package com.ayros.painter.shapes

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Path
import android.view.SurfaceHolder

class PathShape(canvas: Canvas? = null, color: Int = Color.WHITE) : Shape(canvas, color) {

    val path = Path()

    override fun startDrawing(x: Float, y: Float) {
        path.moveTo(x, y)
    }

    override fun endDrawing(x: Float, y: Float) {
        path.lineTo(x, y)
    }

    override fun draw() {
        canvas?.drawPath(path,paint)
    }
}