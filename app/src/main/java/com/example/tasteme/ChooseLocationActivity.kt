package com.example.tasteme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.tasteme.databinding.ActivityChooseLocationBinding

class ChooseLocationActivity : AppCompatActivity() {

    private val binding: ActivityChooseLocationBinding by lazy {
        ActivityChooseLocationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val locationList = arrayOf("Siliguri", "Kolkata", "Malda")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, locationList)
        binding.listOfLocation.setAdapter(adapter)
    }
}