package com.example.jetpacksub1.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.jetpacksub1.databinding.ActivitySplashScreenBinding
import com.example.jetpacksub1.home.MainActivity
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.ChasingDots

class SplashScreen : AppCompatActivity() {

    private val timeOut = 1500L
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val progressBar: Sprite = ChasingDots()
        binding.progressBar.setIndeterminateDrawable(progressBar)

        Handler(mainLooper).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, timeOut)
    }
}