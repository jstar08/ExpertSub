package com.example.jetpacksub1.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jetpacksub1.R
import com.example.jetpacksub1.favorite.databinding.ActivityMainBinding
import com.example.jetpacksub1.favorite.di.favoriteModule
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.core.context.loadKoinModules

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoriteModule)

        adapter = MainAdapter(this)
        binding.viewPagerDetail.adapter = adapter
        binding.viewPagerDetail.offscreenPageLimit = adapter.itemCount

        TabLayoutMediator(
            binding.tabLayoutDetail,
            binding.viewPagerDetail
        ) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.favorite_movie)
                1 -> tab.text = getString(R.string.favorite_tv)
            }
        }.attach()
    }
}