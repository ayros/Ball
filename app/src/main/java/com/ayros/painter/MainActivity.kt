package com.ayros.painter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ayros.painter.shapes.*
import com.ayros.painter.ui.main.ShapeGen
import kotlinx.android.synthetic.main.main_fragment.*

class MainActivity : AppCompatActivity(), ShapeGen {

    lateinit var shape: Shape

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_fragment)
        drawing.shapeGen = this
        drawing.erase()
        erase.setOnClickListener { s -> drawing.erase() }
    }

    override fun createShape() = when(materialButtonToggleGroup.checkedButtonId){
         point.id -> PathShape(drawing.canvas)
        circle.id -> CircleShape(drawing.canvas)
        line.id -> LineShape(drawing.canvas)
        oval.id -> OvalShape(drawing.canvas)
        else -> PathShape(drawing.canvas)
    }
}
