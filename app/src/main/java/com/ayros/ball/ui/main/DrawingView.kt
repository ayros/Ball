package com.ayros.ball.ui.main

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.core.view.drawToBitmap
import com.ayros.ball.animation.BallThread
import com.ayros.ball.shapes.OvalShape
import java.lang.IllegalStateException

class DrawingView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : SurfaceView(context, attrs, defStyleAttr),SurfaceHolder.Callback,Runnable{

    private val surfaceHolder:SurfaceHolder = holder
    private lateinit var thread : BallThread
    lateinit var shape : OvalShape
    //val shapes = mutableListOf<Shape>()
    var canvas : Canvas? = null
    var isDrawing = false

    init {
        surfaceHolder.addCallback(this)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        when(event?.action){
            MotionEvent.ACTION_DOWN -> if(shape.rect.contains(event.x,event.y)) thread.stopBall(event.x, event.y)
            MotionEvent.ACTION_UP -> if(thread.vectorX == 0f && thread.vectorY == 0f) thread.resumeBall(event.x, event.y)
        }
        //if(shape.rect.contains(event.x, event.y)){


        return true
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        Log.d("created", "created")
        isDrawing = true
        shape = OvalShape(canvas)
        val rect = RectF(0f,0f, width.toFloat(),height.toFloat())
        thread = BallThread(shape,rect)
        surfaceHolder.addCallback(thread)
        Thread(thread).start()
        Thread(this).start()
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {

    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        isDrawing = false
        surfaceHolder.removeCallback(this)
    }

    override fun run() {
        while (isDrawing){
            try {
                asyncDraw()
            }catch (e: IllegalStateException){

            }
        }
    }

    fun asyncDraw(){
        try {
            val bitmap = drawToBitmap()
            val canv = Canvas(bitmap)
            canv.drawColor(Color.WHITE)
            canvas = surfaceHolder.lockCanvas()
            canvas?.drawBitmap(bitmap,0f,0f,shape.paint)
            shape.canvas = canvas
            shape.draw()
        }catch (e : Exception){
            e.printStackTrace()
        }
        finally {
            surfaceHolder.unlockCanvasAndPost(canvas)
        }
    }

    fun erase(){
        //shape?.startDrawing(0f,0f)
    }

}