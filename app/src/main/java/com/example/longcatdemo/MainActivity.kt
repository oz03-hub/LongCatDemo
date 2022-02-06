package com.example.longcatdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class MainActivity : AppCompatActivity(), CustomAdapter.OnItemClickListener {
    var listOfBuilding = getBuildings()
    var listOfBuildingData = prepBuildingDataList(listOfBuilding)
    var adapter = CustomAdapter(listOfBuildingData, this)

    fun getBuildings() : List<Building> {
        val listNow = ArrayList<Building>()

        //Failed to read from a CSV file in Kotlin
        listNow.add(Building("Dickinson Hall,68.77,16755.32,true,https://www.umass.edu/living/residence/orchard/dickinson,151 Orchard Hill Drive"))
        listNow.add(Building("Webster Hall,99.3,25056.67,true,https://www.umass.edu/living/residence/orchard/webster,141 Orchard Hill Drive"))
        listNow.add(Building("Grayson Hall,79.34,45.3,false,https://www.umass.edu/living/residence/orchard/grayson,161 Orchard Hill Drive"))
        listNow.add(Building("Field Hall,64.42,15894.56,false,https://www.umass.edu/living/residence/orchard/field,171 Orchard Hill Drive"))

        return listNow
    }

    fun prepBuildingDataList(list: List<Building>) : List<BuildingData> {
        val arrList = ArrayList<BuildingData>()

        for (i in list.indices) {
            arrList.add(BuildingData(list.get(i).hall_name, R.drawable.ic_baseline_apartment_24))
        }

        return arrList
    }

    override fun onItemClick(position: Int) {
        val clicked = listOfBuilding[position]
        Toast.makeText(this, "Clicked ${clicked.hall_name}", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, BuildingActivity::class.java)
        intent.putExtra("whole", clicked)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*
        list = getBuildings()
        dataList = prepBuildingDataList(list!!)
*/

        var rcView: RecyclerView = findViewById(R.id.rvBuildings)
        rcView.adapter = CustomAdapter(listOfBuildingData, this)
        rcView.layoutManager = LinearLayoutManager(this)
        rcView.setHasFixedSize(true)

    }
}
