package com.ayros.painter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ayros.painter.shapes.CircleShape
import com.ayros.painter.shapes.LineShape
import com.ayros.painter.shapes.PathShape
import com.ayros.painter.shapes.Shape
import com.ayros.painter.ui.main.DrawingView
import com.ayros.painter.ui.main.ShapeGen
import kotlinx.android.synthetic.main.main_fragment.*

class MainActivity : AppCompatActivity(), ShapeGen {

    lateinit var shape: Shape

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_fragment)
        drawing.shapeGen = this
        shape = PathShape(drawing.canvas)
        point.setOnClickListener{shape = PathShape(drawing.canvas)}
        circle.setOnClickListener { shape = CircleShape(drawing.canvas) }
    }

    override fun createShape() = when(materialButtonToggleGroup.checkedButtonId){
         point.id -> PathShape(drawing.canvas)
        circle.id -> CircleShape(drawing.canvas)
        line.id -> LineShape(drawing.canvas)
        else -> PathShape(drawing.canvas)
    }
}
