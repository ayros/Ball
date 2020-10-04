package com.ayros.painter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ayros.painter.ui.main.DrawingView
import com.ayros.painter.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(DrawingView(this))
        /*if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }*/
    }
}
