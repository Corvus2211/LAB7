package com.example.lab07
// ThirdActivity.kt

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class ThirdActivity : ComponentActivity() {

    private val tag = "LifecycleDemo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "ThirdActivity → onCreate")

        setContent {
            LifecycleScreen(
                title = "Activity 3",
                currentLifecycle = "onCreate → onStart → onResume",
                onBack = {
                    Log.d(tag, "ThirdActivity → Navigasi kembali ke SecondActivity")
                    finish()
                },
                //onNext = null // Tidak ada next
                // Tombol Next → navigasi ke FourthActivity
                onNext = {
                    Log.d(tag, "ThirdActivity → Navigasi ke FourthActivity")
                    startActivity(Intent(this, FourthActivity::class.java))
                }

            )
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "ThirdActivity → onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "ThirdActivity → onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "ThirdActivity → onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "ThirdActivity → onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "ThirdActivity → onDestroy")
    }
}
