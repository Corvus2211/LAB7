package com.example.lab07

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {

    private val tag = "LifecycleDemo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "MainActivity → onCreate")

        setContent {
            LifecycleScreen(
                title = "Activity 1",
                currentLifecycle = "onCreate → onStart → onResume",
                onNext = {
                    Log.d(tag, "MainActivity → Navigasi ke SecondActivity")
                    startActivity(Intent(this, SecondActivity::class.java))
                }
            )
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "MainActivity → onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "MainActivity → onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "MainActivity → onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "MainActivity → onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "MainActivity → onDestroy")
    }
}
