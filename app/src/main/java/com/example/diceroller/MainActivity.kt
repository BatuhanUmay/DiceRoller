package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDice: Button = findViewById(R.id.button)

        btnDice.setOnClickListener {
            rollDice()
        }

        rollDice() //her açtığımızda farklı gelmesi için yazdık
    }

    fun rollDice() {
        val image: ImageView = findViewById(R.id.imageView)
        val dice = Dice(6)
        val rolledDice = dice.roll()

        val turnedImage = when(rolledDice){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        image.setImageResource(turnedImage)
    }
}

class Dice(val numSide: Int) {

    fun roll(): Int {
        return (1..numSide).random()
    }

}