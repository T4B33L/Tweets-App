package com.example.tweeto1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tweeto1.screens.CategoryScreen
import com.example.tweeto1.screens.TweetScreen
import com.example.tweeto1.ui.theme.Tweeto1Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tweeto1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {TopAppBar(title = {Text(text = "Tweeto")}, colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black, titleContentColor = Color.White) )}
                    ) {
                        Box(modifier = Modifier.padding(it)) {
                            App()
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun App(){

    val navController = rememberNavController()
    NavHost(navController = navController , startDestination = "category"){
        composable(route = "category"){
            CategoryScreen{
                navController.navigate("Tweets/${it}")
            }
        }
        composable(route = "Tweets/{category}", arguments = listOf(
            navArgument("category"){
                type = NavType.StringType
            }
        )){
            TweetScreen()
        }
    }

}
