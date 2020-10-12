package com.ayros.ball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ayros.ball.ui.main.DrawingView


class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(DrawingView(this))
    }
}
