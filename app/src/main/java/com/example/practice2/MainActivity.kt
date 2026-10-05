package com.example.practice2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.practice2.ui.theme.Practice2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practice2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SecondTask()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    Box(
        modifier = Modifier
            .size(240.dp, 120.dp)
            .background(color = Color.Black),
        contentAlignment = Alignment.TopEnd
    ){
        Image(
            painter = painterResource( R.drawable.custom_circle),
            contentDescription = null
        )
    }
}
@Composable
fun SecondTask(){
    Box(
        modifier = Modifier
            .size(240.dp, 120.dp)
            .background(color = Color.Blue),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource( R.drawable.custom_circle),
            modifier = Modifier.fillMaxSize(),

            contentScale = ContentScale.FillBounds,
            colorFilter = ColorFilter.tint(Color(0xFF9C27B0)),
            contentDescription = null
        )
    }
}

