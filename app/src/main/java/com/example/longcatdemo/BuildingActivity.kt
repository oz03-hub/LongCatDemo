package com.example.longcatdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class BuildingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.building_info)

        var par:Boolean = false

        val current: Building? = intent.getSerializableExtra("whole") as Building?
        val txt: TextView = findViewById(R.id.buildingName)
        if (current != null) {
            txt.text = current.hall_name
        }

        val address: TextView = findViewById(R.id.addressBlock)
        if (current != null) {
            address.text = current.address
        }

        val temp: TextView = findViewById(R.id.buildingHeat)
        if (current != null) {
            temp.text = "Temperature: ${current.temperature} F"
            if (current.temperature > 70.0 || current.temperature < 66.0) {
                par = true
                temp.setTextColor(Color.RED)
            }
        }

        val kwUse: TextView = findViewById(R.id.buildingKW)
        if (current != null) {
            kwUse.text = "KW usage(past hour): ${current.kw}"
            if (current.kw > 17500.0 || current.kw < 62.5) {
                par = true
                kwUse.setTextColor(Color.RED)
            }
        }

        val trashSt: TextView = findViewById(R.id.buildingTrash)
        if (current != null) {
            trashSt.text = "Trash gathered: ${current.trashStat}"
            if (!current.trashStat) {
                par = true
                trashSt.setTextColor(Color.RED)
            }
        }

        val msg: TextView = findViewById(R.id.warning) as TextView

        if (par) {
            msg.visibility = View.VISIBLE
        } else {
            msg.visibility = View.INVISIBLE
        }

        val bttn: Button = findViewById(R.id.button) as Button

        bttn.setOnClickListener {
            if (current != null) {
                Toast.makeText(this, "Directing to ${current.url}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}