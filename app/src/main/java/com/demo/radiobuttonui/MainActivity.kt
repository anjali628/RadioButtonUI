package com.demo.radiobuttonui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.radiobuttonui.ui.theme.RadioButtonUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RadioButtonUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   // Greeting("Android")
                    RadioButtonUI()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RadioButtonUITheme {
        Greeting("Android")
    }
}


@Composable
fun  RadioButtonUI(){

    val genderList by remember {
        mutableStateOf(listOf("Male","Female","Others"))
    }

    var genderState by remember {
        mutableStateOf("")
    }

    Column( modifier = Modifier
        .fillMaxSize()
        .padding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center)
        {
            genderList.forEach{
                Row(modifier = Modifier.padding(horizontal = 10.dp)) {
                    Text(text = it, modifier = Modifier.align(Alignment.CenterVertically))
                    RadioButton(selected = genderState == it,
                        onClick = {
                            genderState = it
                        },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color.Green
                        ))
                }
            }
        }

        Text(text = genderState, modifier = Modifier.padding(vertical = 20.dp))

    }


}