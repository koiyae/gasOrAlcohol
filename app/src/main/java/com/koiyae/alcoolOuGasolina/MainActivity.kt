package com.koiyae.alcoolOuGasolina

import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.koiyae.alcoolOuGasolina.ui.theme.PrecosTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrecosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    app(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun app(modifier: Modifier = Modifier) {

    var valorGasolina by remember {
        mutableStateOf("")
    }

    var valorAlcool by remember {
        mutableStateOf("")
    }


    Column(
        modifier = modifier
            .background(color = Color(0xFF9C8737))
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Álcool ou Gasolina",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            
            AnimatedVisibility(visible = valorAlcool.isNotBlank() && valorGasolina.isNotBlank()) {
                if(valorAlcool.isNotBlank() && valorGasolina.isNotBlank()){
                    var isGasolina = valorAlcool.toDouble() / valorGasolina.toDouble() > 0.7
                    val alcoolOuGasolina = if (isGasolina) {
                        "Gasolina"
                    } else {
                        "Álcool"
                    }
                    val cor = if (isGasolina) {
                        Color.Red
                    } else {
                        Color.Green
                    }
                    Text(
                        text = alcoolOuGasolina,
                        style = TextStyle(
                            color = cor,
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }


            TextField(
                value = valorGasolina,
                onValueChange = {
                    valorGasolina = it
                },
                label = {
                    Text(text = "Gasolina")
                }
            )
            TextField(
                value = valorAlcool,
                onValueChange = {
                    valorAlcool = it
                },
                label = {
                    Text(text = "Álcool")
                }
            )
        }
    }
}

@Preview
@Composable

fun appPreview() {
    PrecosTheme {
        app()
    }
}
