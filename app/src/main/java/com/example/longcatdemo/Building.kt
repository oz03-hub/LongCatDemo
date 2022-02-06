package com.example.longcatdemo

import java.io.Serializable

class Building constructor(whole: String) : Serializable{
    companion object {
        fun extractVals(whole: String): List<String> {
            return whole.split(",")
        }
    }

    var hall_name: String = "Unknown"
    var temperature: Double = 70.0
    var kw: Double = 100.0
    var trashStat: Boolean = false
    var url: String = "URL"
    var address: String = "address"

    init {
        val list = Building.extractVals(whole)
        this.hall_name = list[0]
        this.temperature = list[1].toDouble()
        this.kw = list[2].toDouble()
        this.trashStat = list[3] == "true"
        this.url = list[4]
        this.address = list[5]
    }

    override fun toString(): String {
        return "Building(hall_name='$hall_name', temperature=$temperature, kw=$kw, trashStat=$trashStat, url='$url', address='$address')"
    }
}