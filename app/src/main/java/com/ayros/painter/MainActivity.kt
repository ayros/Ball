package com.ayros.painter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ayros.painter.shapes.*
import com.ayros.painter.ui.main.ShapeGen
import kotlinx.android.synthetic.main.main_fragment.*

class MainActivity : AppCompatActivity(), ShapeGen {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_fragment)
        drawing.shapeGen = this
        drawing.erase()
        erase.setOnClickListener { s -> drawing.erase() }
    }

    override fun createShape() = when(shapeButtonToggleGroup.checkedButtonId){
        point.id -> PathShape(drawing.canvas, getShapeColor())
        circle.id -> CircleShape(drawing.canvas, getShapeColor())
        line.id -> LineShape(drawing.canvas, getShapeColor())
        oval.id -> OvalShape(drawing.canvas, getShapeColor())
        rect.id -> RectangleShape(drawing.canvas, getShapeColor())
        else -> PathShape(drawing.canvas, getShapeColor())
    }

    fun getShapeColor() = when(colorButtonToggleGroup.checkedButtonId){
        colorBlack.id -> Color.BLACK
        colorRed.id -> Color.RED
        colorGreen.id -> Color.GREEN
        colorBlue.id -> Color.BLUE
        else -> Color.BLACK
    }
}
