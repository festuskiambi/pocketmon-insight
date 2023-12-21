package com.example.pocketmoninsight

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pocketmoninsight.navigation.AppNavGraph
import com.example.pocketmoninsight.navigation.NavigationProvider
import com.example.pocketmoninsight.ui.theme.PocketMonInsightTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationProvider: NavigationProvider
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PocketMonInsightTheme {
                val navController = rememberNavController()
                App(
                    navHostController = navController,
                    navigationProvider = navigationProvider
                )
            }
        }
    }
}

@Composable
fun App(navHostController: NavHostController, navigationProvider: NavigationProvider) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        AppNavGraph(navController = navHostController, navigationProvider = navigationProvider)
    }
}