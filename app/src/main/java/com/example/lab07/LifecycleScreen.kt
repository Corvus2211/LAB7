package com.example.lab07

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class) // 👈 untuk CenterAlignedTopAppBar
@Composable

fun LifecycleScreen(
    title: String,
    currentLifecycle: String,
    onNext: (() -> Unit)? = null,
    onBack: (() -> Unit)? = null // ✅ Tambahkan parameter ini
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Lifecycle Demo") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text("Status Lifecycle Saat Ini:", fontWeight = FontWeight.SemiBold)
                    Text(currentLifecycle, fontSize = 16.sp)
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Tombol Back
            if (onBack != null) {
                Button(
                    onClick = onBack,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ) {
                    Text("Kembali")
                }
            }

            // Tombol Next
            if (onNext != null) {
                Button(
                    onClick = onNext,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Ke Activity Berikutnya")
                }
            } else if (onBack == null) {
                Text(
                    "Ini Activity Terakhir",
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}
