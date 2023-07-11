package com.example.dice_game

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.dice_game.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var timer: CountDownTimer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Glide.with(this).asGif().load(R.drawable.my_gif_image).into(binding.imageView)
        binding.generatedButton.setOnClickListener {
            onGenerationsClick()
        }
    }

    @SuppressLint("DrawableType")
    private fun onGenerationsClick() {

        val randomNumber = Random.nextInt(1, 7)
        timer?.cancel()
        timer = object : CountDownTimer(3000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                Glide.with(this@MainActivity).asGif().load(R.drawable.my_gif_image).into(binding.imageView)
            }
        }.start()
        when (randomNumber) {
            1 -> binding.imageView?.setImageResource(R.drawable.dice_1)
            2 -> binding.imageView?.setImageResource(R.drawable.dice_2)
            3 -> binding.imageView?.setImageResource(R.drawable.dice_3)
            4 -> binding.imageView?.setImageResource(R.drawable.dice_4)
            5 -> binding.imageView?.setImageResource(R.drawable.dice_5)
            6 -> binding.imageView?.setImageResource(R.drawable.dice_6)
        }
    }

}
