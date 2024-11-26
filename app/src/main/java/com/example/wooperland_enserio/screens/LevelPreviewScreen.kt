package com.example.wooperland_enserio.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wooperland_enserio.R
import com.example.wooperland_enserio.navigation.NavScreen
import com.example.wooperland_enserio.ui.theme.Wooperland_enserioTheme

@Composable
fun LevelPreviewScreen(navController: NavController) {
    // Custom font
    val pixelFont = FontFamily(Font(R.font.press_start_2p))

    // Configuration for responsive design
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    // Background gradient colors
    val gradientColors = listOf(
        Color(0xFFFF69B4), // Pink
        Color(0xFF9370DB), // Purple
        Color(0xFF4169E1)  // Blue
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(gradientColors)
            )
    ) {
        // Background image
        // TODO: Add your pixel art background image here
         Image(
             painter = painterResource(id = R.drawable.levelpreview),
             contentDescription = null,
             modifier = Modifier.fillMaxSize(),
             contentScale = ContentScale.FillBounds
         )

        // Main content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top bar with back button and title
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(40.dp)
                        .clickable { navController.popBackStack() },
                    tint = Color.Black
                )

                Text(
                    text = "MATEMATICAS",
                    fontFamily = pixelFont,
                    fontSize = 20.sp,
                    color = Color(0xFFFFD700), // Golden yellow
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        shadow = Shadow(
                            color = Color.Black,
                            offset = Offset(4f, 4f),
                        )
                    ),

                )

                // Placeholder for symmetry
                Spacer(modifier = Modifier.size(48.dp))
            }

            // Main content spacing
            Spacer(modifier = Modifier.height(if (isLandscape) 16.dp else 48.dp))

            // Number blocks
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(60.dp)
            ) {
                // Number block 3
                NumberBlock(
                    number = "3",
                    backgroundColor = Color(0xFF408C3A), // Dark green
                    pixelFont = pixelFont,
                    onClick = { /* Navigate to level 3 */ }
                )

                // Number block 2
                NumberBlock(
                    number = "2",
                    backgroundColor = Color(0xFFFFD700), // Golden yellow
                    pixelFont = pixelFont,
                    onClick = { /* Navigate to level 2 */ }
                )

                // Number block 1
                NumberBlock(
                    number = "1",
                    backgroundColor = Color(0xFF87CEEB), // Sky blue
                    pixelFont = pixelFont,
                    onClick = { navController.navigate(NavScreen.LevelScreen.name) }
                )
            }

            // Bottom decorative elements
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(top = 24.dp)
            ) {
                // TODO: Add your decorative flower images here
                // Row(
                //     modifier = Modifier.fillMaxWidth(),
                //     horizontalArrangement = Arrangement.SpaceEvenly
                // ) {
                //     Image(
                //         painter = painterResource(id = R.drawable.pixel_flower),
                //         contentDescription = null,
                //         modifier = Modifier.size(40.dp)
                //     )
                //     // Add more flowers as needed
                // }
            }
        }
    }
}

@Composable
fun NumberBlock(
    number: String,
    backgroundColor: Color,
    pixelFont: FontFamily,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(backgroundColor)
            .clickable(onClick = onClick)
            .border(2.dp, Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = number,
            fontFamily = pixelFont,
            fontSize = 65.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.LightGray,
                    offset = Offset(5f, 5f),
                )
            ),
        )
    }
}

// Preview
@Preview(
    showBackground = true,
    widthDp = 360,
    heightDp = 640
)
@Preview(
    showBackground = true,
    widthDp = 640,
    heightDp = 360
)

@Composable
fun LevelPreviewScreen() {
    Wooperland_enserioTheme {
        LevelPreviewScreen(rememberNavController())
    }

}