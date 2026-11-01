package com.medlabel.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.medlabel.app.ui.AppNavGraph
import com.medlabel.app.ui.theme.MedLabelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MedLabelTheme {
                AppNavGraph()
            }
        }
    }
}
