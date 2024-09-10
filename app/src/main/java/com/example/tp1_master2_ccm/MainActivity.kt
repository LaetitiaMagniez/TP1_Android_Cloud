package com.example.tp1_master2_ccm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.tp1_master2_ccm.ui.navigation.HomeNavHost
import com.example.tp1_master2_ccm.ui.theme.TP1_Master2_CCMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TP1_Master2_CCMTheme {
                val navController = rememberNavController()
                HomeNavHost(
                    navController = navController
                )
            }
        }
    }
}









