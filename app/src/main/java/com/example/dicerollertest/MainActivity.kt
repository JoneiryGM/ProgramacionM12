package com.example.dicerollertest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dicerollertest.ui.theme.DIceRollerTestTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DIceRollerTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DiceRollerApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun DiceRollerApp(modifier: Modifier = Modifier) {
    var diceRoll by remember { mutableStateOf(1) } // Estado para cambiar la imagen del dado

    val diceImages = listOf(
        R.drawable.dice_1, // Reemplaza con los nombres de tus imágenes
        R.drawable.dice_2,
        R.drawable.dice_3,
        R.drawable.dice_4,
        R.drawable.dice_5,
        R.drawable.dice_6
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = diceImages[diceRoll - 1]),
            contentDescription = "Dado con valor $diceRoll",
            modifier = Modifier.size(150.dp) // Ajusta el tamaño según sea necesario
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { diceRoll = Random.nextInt(1, 7) }, // Genera un número aleatorio del 1 al 6
            elevation = ButtonDefaults.buttonElevation(4.dp)
        ) {
            Text("ROLL")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DIceRollerTestTheme {
        DiceRollerApp()
    }
}
