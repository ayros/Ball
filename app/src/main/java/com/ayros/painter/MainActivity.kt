package com.ayros.painter

import android.graphics.Color
import android.graphics.RectF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ayros.painter.animation.BallThread
import com.ayros.painter.shapes.*
import com.ayros.painter.ui.main.DrawingView
import kotlinx.android.synthetic.main.main_fragment.*

class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(DrawingView(this))
    }
}
