package com.ayros.painter.ui.main

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.core.view.drawToBitmap
import com.ayros.painter.shapes.CircleShape
import com.ayros.painter.shapes.PathShape
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
    var shape = CircleShape(surfaceHolder)
    var isDrawing = false

    init {
        surfaceHolder.addCallback(this)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        when(event?.action){
            MotionEvent.ACTION_DOWN -> shape.startDrawing(event.x,event.y)
            MotionEvent.ACTION_MOVE -> shape.endDrawing(event.x,event.y)
            MotionEvent.ACTION_UP -> shape.endDrawing(event.x,event.y)

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

                shape.asyncDraw()
            }catch (e: IllegalStateException){

            }
        }
    }
}