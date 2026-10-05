package com.example.practice2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice2.ui.theme.Practice2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practice2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SeventhTaskThirdScreen()
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

@Composable
fun SeventhTaskFirstScreen(){
    val name= "Евгений"
    val lastName= "Андреевич"
    val middleName = "Лукашин"
    val phone= "+7 495 495 95 95"
    val address = "г. Москва, 3-я улица Строителей, д.25, кв.12"
    Column (modifier = Modifier.padding(20.dp)) {
        Text("Имя: ${name}")
        Text("Отчество: ${lastName}")
        Text("Фамилия: ${middleName}")
        Text("Мобильный телефон: ${phone}")
        Text("Адрес: ${address}")
    }
}

@Composable
fun SevenTaskSecondScreen(){
    val list = PeopleList.list
    Column (
        modifier = Modifier.fillMaxWidth()
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        for(person in list){
            Column  (
                modifier = Modifier.fillMaxWidth()
                    .background(Color.Gray)
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Text("Имя: ${person.firstName}")
                Text("Отчество: ${person.lastName}")
                Text("Фамилия: ${person.middleName}")
                Text("Мобильный телефон: ${person.phone}")
                Text("Адрес: ${person.address}")
            }
        }
    }
}

@Composable
fun SeventhTaskThirdScreen(){
    val firstName= "Евгений"
    val lastName= "Андреевич"
    val middleName = "Лукашин"
    val phone= "+7 495 495 95 95"
    val address = "г. Москва, 3-я улица Строителей, д.25, кв.12"
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(Color.Gray)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column  (
            modifier = Modifier
                .weight(1f)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){

            Text("Имя: ${firstName}")
            Text("Отчество: ${lastName}")
            Text("Фамилия: ${middleName}")
            Text("Мобильный телефон: ${phone}")
            Text("Адрес: ${address}")
        }
        Image(
            painter = painterResource(R.drawable.baseline_star_purple500_24),
            contentDescription = null
        )
    }
}


