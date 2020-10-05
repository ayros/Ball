package com.ayros.painter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ayros.painter.shapes.PathShape
import com.ayros.painter.ui.main.DrawingView
import com.ayros.painter.ui.main.MainFragment
import kotlinx.android.synthetic.main.main_fragment.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_fragment)
        drawing.shape = PathShape()
        /*if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }*/
    }
}
