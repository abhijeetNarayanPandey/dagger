package com.nasacode.daggermvvm.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.nasacode.daggermvvm.R
import com.nasacode.daggermvvm.utils.Resource
import com.nasacode.daggermvvm.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewNasaActivity :AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    private val title: TextView
    get() = findViewById(R.id.title)
    private val imageView: ImageView
        get() = findViewById(R.id.imageView)
    private val description:TextView
    get() = findViewById(R.id.description)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nasa_activity)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.nasaLiveData.observe(this, Observer {response->
            when(response) {
                is Resource.Loading ->{

                }
                is Resource.Success -> {
                    title.text = response.data?.title
                    description.text = response.data?.explanation
                    Glide.with(this).load(response.data?.hdurl).into(imageView)
                }
                is Resource.Error ->{

                }
            }
        })
    }
}