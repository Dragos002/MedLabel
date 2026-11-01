package com.medlabel.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.medlabel.app.model.MedicationEntry

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleScreen(
    medications: List<MedicationEntry>,
    onNavigateToScanner: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("MedLabel - Schedule") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = onNavigateToScanner,
                icon = { Icon(Icons.Default.Add, contentDescription = "Scan Label") },
                text = { Text("Scan Label") },
                containerColor = MaterialTheme.colorScheme.primary
            )
        }
    ) { paddingValues ->
        if (medications.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No medications added.\nTap 'Scan Label' to parse a bottle.",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(medications) { med ->
                    MedicationCard(medication = med)
                }
            }
        }
    }
}

@Composable
fun MedicationCard(medication: MedicationEntry) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = medication.medicationName,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                AssistChip(
                    onClick = { },
                    label = { Text(medication.syncStatus, fontSize = 10.sp) }
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Dosage: ${medication.dosage}", fontWeight = FontWeight.Medium)
            Text(text = "Instructions: ${medication.instructions}")
        }
    }
}
