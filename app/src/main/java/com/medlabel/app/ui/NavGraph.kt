package com.medlabel.app.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.medlabel.app.model.MedicationEntry

sealed class Screen(val route: String) {
    object Schedule : Screen("schedule")
    object Scanner : Screen("scanner")
}

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    
    // In-memory mock list for M1 prototype state
    val mockMedications = remember {
        mutableStateListOf(
            MedicationEntry(
                id = "1",
                medicationName = "Lisinopril",
                dosage = "10mg",
                instructions = "Take 1 tablet daily in the morning",
                syncStatus = "LOCAL_ONLY"
            ),
            MedicationEntry(
                id = "2",
                medicationName = "Metformin",
                dosage = "850mg",
                instructions = "Take 1 tablet twice daily with meals",
                syncStatus = "LOCAL_ONLY"
            )
        )
    }

    NavHost(navController = navController, startDestination = Screen.Schedule.route) {
        composable(Screen.Schedule.route) {
            ScheduleScreen(
                medications = mockMedications,
                onNavigateToScanner = { navController.navigate(Screen.Scanner.route) }
            )
        }
        composable(Screen.Scanner.route) {
            ScannerScreen(
                onNavigateBack = { navController.popBackStack() },
                onMedicationSaved = { newEntry ->
                    mockMedications.add(newEntry)
                    navController.popBackStack()
                }
            )
        }
    }
}
