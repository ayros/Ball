package com.ayros.painter.shapes

import android.graphics.Color
import android.util.Log
import android.view.SurfaceHolder
import kotlin.math.sqrt

class CircleShape(surfaceHolder: SurfaceHolder, color: Int = Color.WHITE) :
    Shape(surfaceHolder, color) {

    var x1 = 0f
    var x2 = 0f
    var y1 = 0f
    var y2 = 0f
    var isDrawing = false

    override fun draw() {
        if (canvas!=null){
            val d = sqrt((x2 - x1) *(x2 - x1) + (y2 - y1)*(y2 - y1))
            canvas.drawCircle(x1, y1, d/2, paint)
        }
    }

    override fun startDrawing(x: Float, y: Float) {
        //canvas = surfaceHolder.lockCanvas()
        x1 = x
        y1 = y
        Log.d("start", "x1 = $x1")
        Log.d("start", "y1 = $y1")
    }

    override fun endDrawing(x: Float, y: Float) {
        //surfaceHolder.unlockCanvasAndPost(canvas)
        x2 = x
        y2 = y
        isDrawing = true
        Log.d("end", "x2 = $x2")
        Log.d("end", "y2 = $y2")
    }
}