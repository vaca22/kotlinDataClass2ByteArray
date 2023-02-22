package com.example.kotlindataclass2bytearray

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.nio.ByteBuffer

data class Ga(var k1: Long, var k2: Double) {
    lateinit var byteArray: ByteArray
    var n1: Long = 0
    var n2: Double = 0.0
    fun toByteArray(): ByteArray? {
        val size: Int = 8 + 8
        val byteBuffer = ByteBuffer.allocate(size)
            .putLong(k1)
            .putDouble(k2)
        byteArray=byteBuffer.array()
        return byteBuffer.array()
    }

    fun getBack() {
        val byteBuffer = ByteBuffer.wrap(byteArray)
        n1 = byteBuffer.getLong()
        n2 = byteBuffer.getDouble()
    }
}


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gg=Ga(234,55.66)
        gg.toByteArray()
        gg.getBack()
        Log.e("nn","asd  ${gg.n1}    ${gg.n2}")
    }
}