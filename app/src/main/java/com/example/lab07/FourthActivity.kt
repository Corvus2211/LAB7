package com.example.lab07

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class FourthActivity : ComponentActivity() {

    private val tag = "LifecycleDemo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "FourthActivity → onCreate")
        setContent {
            FourthScreen(
                onNavigateBack = {
                    Log.d(tag, "FourthActivity → Navigasi kembali ke ThirdActivity")
                    finish() // Closes this activity and returns to the previous one
                }
            )
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "FourthActivity → onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "FourthActivity → onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "FourthActivity → onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "FourthActivity → onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "FourthActivity → onDestroy")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FourthScreen(onNavigateBack: () -> Unit) {
    var textInput by remember { mutableStateOf("") }
    var textForFrame2 by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Fourth Activity") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        bottomBar = {
            Button(
                onClick = onNavigateBack,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Kembali ke ThirdActivity")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding) // Apply padding from Scaffold
                .padding(16.dp), // Add additional padding for content
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Frame 1
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f), // Takes up available space
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE0E0FF)) // Light blueish
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text("Masukkan Text 1", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = textInput,
                        onValueChange = { textInput = it },
                        label = { Text("fadliadifadia") }, // Placeholder example
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = { textForFrame2 = textInput }) {
                        Text("Button 1: Kirim ke Frame 2")
                    }
                }
            }

            // Frame 2
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f), // Takes up available space
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF0E0)) // Light yellowish
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = if (textForFrame2.isEmpty()) "Frame 2 menunggu..." else "Frame 2 menerima: $textForFrame2",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
            // The bottom navigation bar with "Kembali ke ThirdActivity" is handled by Scaffold's bottomBar
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FourthScreenPreview() {
    MaterialTheme { // Ensure a MaterialTheme is applied for previews
        FourthScreen(onNavigateBack = {})
    }
}
