package com.example.headspaceapplication.view

import android.os.Bundle
import com.example.headspaceapplication.R
import com.example.headspaceapplication.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.root

class MainActivity : DaggerAppCompatActivity() {

    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.bind(root)
        binding?.let {
            setContentView(it.root)
        }
    }
}
