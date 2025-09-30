package com.example.lab07

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class SecondActivity : ComponentActivity() {

    private val tag = "LifecycleDemo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "SecondActivity → onCreate")

        setContent {
            LifecycleScreen(
                title = "Activity 2",
                currentLifecycle = "onCreate → onStart → onResume",
                // Tombol Back → kembali ke MainActivity
                onBack = {
                    Log.d(tag, "SecondActivity → Kembali ke MainActivity")
                    finish()
                },
                // Tombol Next → navigasi ke ThirdActivity
                onNext = {
                    Log.d(tag, "SecondActivity → Navigasi ke ThirdActivity")
                    startActivity(Intent(this, ThirdActivity::class.java))
                }
            )
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "SecondActivity → onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "SecondActivity → onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "SecondActivity → onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "SecondActivity → onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "SecondActivity → onDestroy")
    }
}
