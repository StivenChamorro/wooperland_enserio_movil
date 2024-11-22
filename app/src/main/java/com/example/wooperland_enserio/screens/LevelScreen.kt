package com.example.wooperland_enserio.screens

import android.content.res.Configuration
import android.speech.tts.TextToSpeech
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.wooperland_enserio.R
import kotlinx.coroutines.*
import java.util.*

@Composable
fun LevelScreen(
    onNavigateBack: () -> Unit,
    navController: NavController
) {
    // Fonts
    val pixelFont = FontFamily(Font(R.font.press_start_2p))
    val happyFont = FontFamily(Font(R.font.happy_monkey))

    // States
    var showPauseDialog by remember { mutableStateOf(false) }
    var showHelpDialog by remember { mutableStateOf(false) }
    var timeLeft by remember { mutableStateOf(180) } // 3 minutes in seconds
    var isTimerRunning by remember { mutableStateOf(true) }

    // TTS Setup
    val context = LocalContext.current
    val tts = remember { TextToSpeech(context) { } }

    // Timer Effect
    LaunchedEffect(isTimerRunning) {
        while (isTimerRunning && timeLeft > 0) {
            delay(1000L)
            timeLeft--
        }
    }

    // Screen configuration
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFD166))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "1 de 15",
                    fontFamily = happyFont,
                    fontSize = 20.sp
                )

                IconButton(onClick = { showPauseDialog = true }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_pause),
                        contentDescription = "Pause",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            // Question Bubble
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                shape = RoundedCornerShape(16.dp),
                color = Color.White,
                shadowElevation = 4.dp
            ) {
                Text(
                    text = "¿Cuanto es 2 mas 2?",
                    fontFamily = pixelFont,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Center
                )
            }

            Image(painter = painterResource(
                id = R.drawable.axolotl), contentDescription =null,
                modifier = Modifier
                    .size(200.dp)
                    .align(Alignment.CenterHorizontally)
            )


//            // Answer Options
//            val answers = listOf(
//                "5" to Color(0xFFB43654),
//                "4" to Color(0xFF1B6286),
//                "1" to Color(0xFF92D3CF),
//                "Ninguna de las anteriores" to Color(0xFFe63946)
//            )
//
//            answers.forEachIndexed { index, (answer, color) ->
//                AnswerButton(
//                    text = answer,
//                    label = ('A' + index).toString(),
//                    color = color,
//                    // = happyFont,
//                    onClick = { /* Handle answer selection */ }
//                )
//                Spacer(modifier = Modifier.height(8.dp))
//            }
//        }

            // Answer grid
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    com.example.matematicas.screens.AnswerButton(
                        text = "5",
                        label = "A",
                        color = Color(0xFFFF69B4),
                        modifier = Modifier.weight(1f),
                        onClick = {}
                    )
                    com.example.matematicas.screens.AnswerButton(
                        text = "4",
                        label = "B",
                        color = Color(0xFF4169E1),
                        modifier = Modifier.weight(1f),
                        onClick = {}
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    com.example.matematicas.screens.AnswerButton(
                        text = "1",
                        label = "C",
                        color = Color(0xFF90EE90),
                        modifier = Modifier.weight(1f),
                        onClick = {}
                    )
                    com.example.matematicas.screens.AnswerButton(
                        text = "Ninguna de las anteriores",
                        label = "D",
                        color = Color(0xFFFF8C00),
                        modifier = Modifier.weight(1f),
                        onClick = {}
                    )
                }
            }
        }

        // Bottom Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Timer
            Text(
                text = "Tiempo: ${String.format("%02d:%02d", timeLeft / 60, timeLeft % 60)}",
                fontFamily = happyFont,
                fontSize = 16.sp
            )

            // Help and Audio buttons
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                IconButton(onClick = { showHelpDialog = true }) {
                    Icon(
                        imageVector = Icons.Default.Help,
                        contentDescription = "Help"
                    )
                }

                IconButton(
                    onClick = {
                        tts.speak(
                            "¿Cuanto es 2 mas 2?",
                            TextToSpeech.QUEUE_FLUSH,
                            null,
                            null
                        )
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.VolumeUp,
                        contentDescription = "Read Question"
                    )
                }
            }
        }
    }

    // Pause Dialog
    if (showPauseDialog) {
        Dialog(onDismissRequest = { showPauseDialog = false }) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color.White
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Juego Pausado",
                        fontFamily = pixelFont,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        isTimerRunning = true
                        showPauseDialog = false
                    }) {
                        Text("Continuar", fontFamily = happyFont)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = onNavigateBack) {
                        Text("Salir", fontFamily = happyFont)
                    }
                }
            }
        }
    }

    // Help Dialog
    if (showHelpDialog) {
        Dialog(onDismissRequest = { showHelpDialog = false }) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color.White
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Ayuda",
                        fontFamily = pixelFont,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    // TODO: Add your help text here
                    Text(
                        text = "Instrucciones del juego...",
                        fontFamily = happyFont
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = { showHelpDialog = false }) {
                        Text("Cerrar", fontFamily = happyFont)
                    }
                }
            }
        }
    }
}

@Composable
fun AnswerButton(
    text: String,
    label: String,
    color: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(16.dp)
            )
            .height(80.dp)
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            // Colored tab with letter
            Box(
                modifier = Modifier
                    .width(40.dp)
                    .fillMaxHeight()
                    .background(
                        color = color,
                        shape = RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = label,
                    color = Color.White,
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.press_start_2p))
                )
            }

            // Answer text
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = text,
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.press_start_2p)),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}