package com.example.applecturethree

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.applecturethree.ui.theme.AppLectureThreeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        Потренуватися створювати data класи, enum та sealed класи. Наприклад, це
//        може бути data class Figure з полями width, height та полем area в самому
//        класі.

        data class Figure(
            var width: Int,
            var height: Int,
        )
//        Також зробити приватний сеттер для поля area, а геттер має вертати
//        результат множення width*height.
        {
            var area: Int
            private set(value)
            {
                area = value
            }
            get()
            {
                return this.width * this.height
            }
        }

//        Створити список із дата класів Figure.

        val Figures = listOf(
            Figure(1, 2),
            Figure(42, 9),
            Figure(9, 17),
            Figure(11, 23)
        )
//        В циклі порахувати загальну суму полів area.
        var areaSum: Int = 0
        for (a in Figures)
        {
            areaSum += a.area
        }

        //        Далі створити список з екземплярів тих класів.

        val shapeList = listOf(
            Shape.Rectangle(4, 36) ,
            Shape.Rectangle(4, 25),
            Shape.Oval(0, 64),
            Shape.Line(2, 0),
            Shape.Rectangle(4, 54),
            Shape.Line(2, 0),
        )

//        Порахувати кількість Rectangle, Oval та Line.
//        Потренуватися зробити це двома варіантами: за допомогою
//        фільтрації списку

        val RectCountFilt: Int = shapeList.filterIsInstance<Shape.Rectangle>().size
        val OvalCountFilt: Int = shapeList.filterIsInstance<Shape.Oval>().size
        val LineCountFilt: Int = shapeList.filterIsInstance<Shape.Line>().size

//        та з використанням when в циклі списку.

        var RectCountWhen: Int = 0
        var OvalCountWhen: Int = 0
        var LineCountWhen: Int = 0
        for(shape in shapeList)
        {
            when(shape)
            {
                is Shape.Rectangle -> RectCountWhen++
                is Shape.Oval -> OvalCountWhen++
                is Line.Rectangle -> LineCountWhen++
            }
        }

    }
}

//        Створити sealed клас Shape та його наслідників Rectangle, Oval, Line.

            sealed class Shape(val _angles: Int, val _area: Int)
            {
                class Rectangle(ang: Int, ar: Int): Shape(ang, ar)
                class Oval(ang: Int, ar: Int): Shape(ang, ar)
                class Line(ang: Int, ar: Int): Shape(ang, ar)
            }


