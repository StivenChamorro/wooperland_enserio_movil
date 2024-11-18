package com.example.wooperland_enserio.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wooperland_enserio.R
import com.example.wooperland_enserio.ui.theme.Wooperland_enserioTheme

@Composable
fun AvatarScreen() {
    //variable para la fuente
    val customFont2 = FontFamily(Font(R.font.happy_monkey))
    var showMenu by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    val images = listOf(
        R.drawable.avatar1,
        R.drawable.avatar2,
        R.drawable.deadpoolwooper,
        R.drawable.avatar3,
        R.drawable.avatar4,
        R.drawable.avatar5,
        R.drawable.avatar6,
        R.drawable.avatar7
    )

    ImageGrid(images)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFD166),
                        Color(0xFFF78D6B)
                    )
                )
            )
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Avatares",
                fontSize = 28.sp,
                fontFamily = customFont2,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .height(42.dp),
                textAlign = TextAlign.Center
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(id = R.drawable.deadpoolwooper),
                contentDescription = "Imagen Principal",
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
            )
        }
    }
    Spacer(modifier = Modifier.height(10.dp))

    // Column para los botones
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
             .padding(top = 180.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Box(
            modifier = Modifier
                .background(
                    Color(0xFFA33B54),
                    shape = RoundedCornerShape(55.dp)
                )
                .padding(16.dp)
        ) {
            Column {
                for (i in images.indices step 3) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(30.dp),
                        modifier = Modifier.padding(bottom = 70.dp),
                        verticalAlignment = Alignment.Bottom,
                    ) {
                        for (j in 0..2) {
                            if (i + j < images.size) {
                                ImageItem(images[i + j])
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ImageGrid(images: List<Int>) {

}

@Composable
fun ImageItem(imageRes: Int) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = null,
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun AvatarPreview() {
    Wooperland_enserioTheme {
        AvatarScreen()
    }
}