package com.medlabel.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.medlabel.app.model.MedicationEntry
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScannerScreen(
    onNavigateBack: () -> Unit,
    onMedicationSaved: (MedicationEntry) -> Unit
) {
    var name by remember { mutableStateOf("Amoxicillin") }
    var dosage by remember { mutableStateOf("500mg") }
    var instructions by remember { mutableStateOf("Take 1 capsule every 8 hours with water") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Scan Prescription Label") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Mock Camera Viewfinder Box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(Color.DarkGray),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "[ Mock Camera Viewfinder / OCR Preview ]",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }

            Text("Parsed Label Confirmation:", fontSize = 18.sp)

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Medication Name") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = dosage,
                onValueChange = { dosage = it },
                label = { Text("Dosage") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = instructions,
                onValueChange = { instructions = it },
                label = { Text("Instructions") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    val entry = MedicationEntry(
                        id = UUID.randomUUID().toString(),
                        medicationName = name,
                        dosage = dosage,
                        instructions = instructions
                    )
                    onMedicationSaved(entry)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Confirm & Save to Schedule")
            }
        }
    }
}
