package com.example.paypalchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.paypalchallenge.ui.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}