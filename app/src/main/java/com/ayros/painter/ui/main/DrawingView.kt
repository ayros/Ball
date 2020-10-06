package com.ayros.painter.ui.main

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.PixelCopy
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.core.graphics.BitmapCompat
import androidx.core.view.drawToBitmap
import com.ayros.painter.shapes.CircleShape
import com.ayros.painter.shapes.PathShape
import com.ayros.painter.shapes.Shape
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import kotlinx.coroutines.launch
import java.lang.IllegalStateException

class DrawingView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : SurfaceView(context, attrs, defStyleAttr),SurfaceHolder.Callback,Runnable{

    private val surfaceHolder:SurfaceHolder = holder
    var shape : Shape? = null
    val shapes = mutableListOf<Shape>()
    var canvas : Canvas? = null
    var isDrawing = false
    lateinit var shapeGen: ShapeGen

    init {
        surfaceHolder.addCallback(this)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        when(event?.action){
            MotionEvent.ACTION_DOWN -> {
                shape = shapeGen.createShape()
                shape?.startDrawing(event.x,event.y)
            }
            MotionEvent.ACTION_MOVE -> shape?.endDrawing(event.x,event.y)
            MotionEvent.ACTION_UP -> {
                shape?.endDrawing(event.x, event.y)
                shapes.add(shape!!)
            }
        }

        return true
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        Log.d("created", "created")
        isDrawing = true
        Thread(this).start()
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
        //var bitmap = this.drawToBitmap()
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
            if(shape != null){
                canvas = surfaceHolder.lockCanvas()
            }
            canvas?.drawBitmap(bitmap,0f,0f,shape?.paint)
            shapes.forEach{s -> s.draw()}
            shape?.draw()
        }catch (e : Exception){
            e.printStackTrace()
        }
        finally {
            if (shape != null){
                surfaceHolder.unlockCanvasAndPost(canvas)
            }
        }
    }

    fun erase(){
        shapes.removeAll(shapes)
        shape = shapeGen.createShape()
        shape?.startDrawing(0f,0f)
    }

}