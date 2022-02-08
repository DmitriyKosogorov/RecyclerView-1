package com.example.recyclerviewcolorsk

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Random

class MainActivity : AppCompatActivity() {

    val planetsList = arrayListOf<String>("Mars", "Venus", "Earth")
    // TODO: реализовать генерацию цветов определённой палитры
    var colorsList = mutableListOf(Color.YELLOW, Color.RED, Color.GREEN, Color.MAGENTA)
    val random=Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        // пример использования RecyclerView с собственным адаптером
        val rv = findViewById<RecyclerView>(R.id.rview)
        val colorAdapter = ColorAdapter(LayoutInflater.from(this))
        // добавляем данные в список для отображения
        colorAdapter.submitList(colorsList)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = colorAdapter
        var strr=""
        val numbers="0123456789abcdef"
        var index=0
        val buttonchik= findViewById<Button>(R.id.shuffler)
        buttonchik.setOnClickListener {
            for(j in 0..3) {
                strr=""
                for (i in 1..8) {
                    index = random.nextInt(16)
                    strr = strr + numbers[index]
                }
                strr='#'+strr
                colorsList[j]=Color.parseColor(strr)
            }
            colorAdapter.submitList(colorsList)
            rv.layoutManager = LinearLayoutManager(this)
        }
    }
}