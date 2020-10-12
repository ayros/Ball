package com.ayros.ball.animation

import android.graphics.RectF
import android.view.SurfaceHolder
import com.ayros.ball.shapes.Shape


class BallThread(val shape: Shape, val cell : RectF) : Runnable, SurfaceHolder.Callback {

    var vectorX = 10f
    var vectorY = 5f

    var stopPointX = 0f
    var stopPointY = 0f
    var resumePointX = 0f
    var resumePointY = 0f

    var isDrawing = true
    init {
        shape.x1 = 10f
        shape.x2 = 80f
        shape.y1 = 10f
        shape.y2 = 80f
    }

    override fun run() {
        while (isDrawing){
            shape.x1 += vectorX
            shape.x2 += vectorX
            shape.y1 += vectorY
            shape.y2 += vectorY
            if(shape.x1 < 0f || shape.x2 > cell.width()) vectorX *= -1
            if(shape.y1 < 0f || shape.y2 > cell.height()) vectorY *= -1
            Thread.sleep(20)
        }


    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        isDrawing = true
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {

    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        isDrawing = false
    }

    fun stopBall(x : Float, y : Float){
        vectorX = 0f
        vectorY = 0f
        stopPointX = x
        stopPointY = y
    }

    fun resumeBall(x : Float, y : Float){
        resumePointX = x
        resumePointY = y
        vectorX = (resumePointX - stopPointX)/50f
        vectorY = (resumePointY - stopPointY)/50f
    }
}