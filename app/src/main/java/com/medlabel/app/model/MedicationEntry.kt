package com.medlabel.app.model

data class MedicationEntry(
    val id: String,
    val medicationName: String,
    val dosage: String,
    val instructions: String,
    val labelImagePath: String? = null,
    val syncStatus: String = "LOCAL_ONLY",
    val nextDoseTimestamp: Long = System.currentTimeMillis() + 86400000L,
    val frequencyMinutes: Int = 1440
)
