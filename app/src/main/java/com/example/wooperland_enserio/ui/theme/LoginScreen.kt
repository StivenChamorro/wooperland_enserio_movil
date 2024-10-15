package com.example.wooperland_enserio.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wooperland_enserio.R


@Composable
fun LoginScreen(){
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFFD166),
            Color(0xFFB43654)
        )
    )
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
            .size(360.dp, 800.dp)
            .clipToBounds(),
    ) {
        // Image-504:1670-Union
        Image(
            painter = painterResource(id = R.drawable.image1_5041670),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 20.dp, y = 23.dp)
                .size(11.667.dp, 11.314.dp),
        )
        // Text-504:1672-Logros
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .wrapContentSize()
                .offset(x = 1.dp, y = 17.dp),
            text = "Logros",
            color = Color(0xff000000),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Image-504:1673-mountains-7728691_640 3
        Image(
            painter = painterResource(id = R.drawable.image2_5041673),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 40.dp, y = 90.dp)
                .size(96.dp, 88.dp),
        )
        // Text-504:1674-Matemáticas
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentSize()
                .offset(x = 159.dp, y = 126.dp),
            text = "Matemáticas",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Image-504:1675-Vector 16
        Image(
            painter = painterResource(id = R.drawable.image3_5041675),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 260.dp, y = 132.dp)
                .size(12.dp, 5.dp),

        )
        // Text-504:1676-DIAMANTES DEL JUGADOR
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentSize()
                .offset(x = 52.dp, y = 199.dp),
            text = "DIAMANTES DEL JUGADOR",
            color = Color(0xff000000),
            fontSize = 10.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-504:1677-LOGROS COMPLETADOS
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentSize()
                .offset(x = 204.dp, y = 199.dp),
            text = "LOGROS COMPLETADOS",
            color = Color(0xff000000),
            fontSize = 10.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Image-504:1678-1664374 11
        Image(
            painter = painterResource(id = R.drawable.image4_5041678),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 40.dp, y = 200.dp)
                .size(9.dp, 8.dp),
        )
        // Image-504:1679-3856511 2
        Image(
            painter = painterResource(id = R.drawable.image5_5041679),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 193.dp, y = 200.dp)
                .size(8.dp, 8.dp),
        )
        // Text-504:1680-2/10
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentSize()
                .offset(x = 213.dp, y = 211.dp),
            text = "2/10",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Text-504:1681-120/1200
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentSize()
                .offset(x = 61.dp, y = 213.dp),
            text = "120/1200",
            color = Color(0xff000000),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )
        // Box-504:1752-Frame 121
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(x = 0.dp, y = 249.dp)
                .size(306.dp, 718.dp),
        ) {
            // Empty-504:1683-Rectangle 694
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(x = -1.dp, y = 0.dp)
                    .advancedShadow(color = Color(0x3f000000), alpha = 0.25f, cornersRadius = 10.dp, shadowBlurRadius = 4.dp, offsetX = 0.dp, offsetY = 4.dp)
                    .background(Color(0xffffd166), RoundedCornerShape(10.dp))
                    .size(304.dp, 78.dp),
            )
            // Image-504:1684-Rectangle 602
            Image(
                painter = painterResource(id = R.drawable.image1_5041684),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .size(74.dp, 78.dp),
            )
            // Text-504:1686-Super Wooper
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentSize()
                    .offset(x = 87.dp, y = 12.dp),
                text = "Super Wooper",
                color = Color(0xff000000),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
            // Text-504:1688-Completa un nivel sin equivocarte ninguna vez
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentHeight()
                    .offset(x = 90.dp, y = 30.dp)
                    .width(172.dp),
                text = "Completa un nivel sin equivocarte ninguna vez",
                color = Color(0xff000000),
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
            // Text-504:1690-20
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentSize()
                    .offset(x = 278.dp, y = 55.dp),
                text = "20",
                color = Color(0xff000000),
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
            // Image-504:1691-1664374 3
            Image(
                painter = painterResource(id = R.drawable.image2_5041691),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 268.dp, y = 62.dp)
                    .size(8.dp, 9.dp),
            )
            // Empty-504:1693-Rectangle 695
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(x = 1.dp, y = 90.dp)
                    .advancedShadow(color = Color(0x3f000000), alpha = 0.25f, cornersRadius = 10.dp, shadowBlurRadius = 4.dp, offsetX = 0.dp, offsetY = 4.dp)
                    .background(Color(0xffffd166), RoundedCornerShape(10.dp))
                    .size(304.dp, 78.dp),
            )
            // Image-504:1700-Rectangle 697
            Image(
                painter = painterResource(id = R.drawable.image3_5041700),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 0.dp, y = 90.dp)
                    .size(78.dp, 78.dp),
            )
            // Text-504:1695-Francesco es tres veces veloz
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentSize()
                    .offset(x = 89.dp, y = 102.dp),
                text = "Francesco es tres veces veloz",
                color = Color(0xff000000),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
            // Text-504:1696-Completa el nivel 5 en menos de 2 minutos
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentHeight()
                    .offset(x = 94.dp, y = 120.dp)
                    .width(172.dp),
                text = "Completa el nivel 5 en menos de 2 minutos",
                color = Color(0xff000000),
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
            // Text-504:1697-20
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentSize()
                    .offset(x = 280.dp, y = 151.dp),
                text = "20",
                color = Color(0xff000000),
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
            // Image-504:1698-1664374 12
            Image(
                painter = painterResource(id = R.drawable.image4_5041698),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 270.dp, y = 152.dp)
                    .size(8.dp, 9.dp),
            )
            // Empty-504:1702-Rectangle 698
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(x = -1.dp, y = 180.dp)
                    .advancedShadow(color = Color(0x3f000000), alpha = 0.25f, cornersRadius = 10.dp, shadowBlurRadius = 4.dp, offsetX = 0.dp, offsetY = 4.dp)
                    .background(Color(0xffffd166), RoundedCornerShape(10.dp))
                    .size(304.dp, 78.dp),
            )
            // Text-504:1704-Compañerismo
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentSize()
                    .offset(x = 91.dp, y = 190.dp),
                text = "Compañerismo",
                color = Color(0xff000000),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
            // Text-504:1705-Utiliza la ayuda de wooper en un nivel
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentHeight()
                    .offset(x = 96.dp, y = 210.dp)
                    .width(172.dp),
                text = "Utiliza la ayuda de wooper en un  nivel",
                color = Color(0xff000000),
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
            // Text-504:1706-20
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentSize()
                    .offset(x = 278.dp, y = 241.dp),
                text = "20",
                color = Color(0xff000000),
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
            // Image-504:1707-1664374 13
            Image(
                painter = painterResource(id = R.drawable.image5_5041707),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 268.dp, y = 242.dp)
                    .size(8.dp, 9.dp),
            )
            // Empty-504:1710-Rectangle 616
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 0.dp, y = 180.dp)
                    .background(Color(0xff605e5e))
                    .size(80.dp, 78.dp),
            )
            // Image-504:1712-747305 8
            Image(
                painter = painterResource(id = R.drawable.image6_5041712),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 26.dp, y = 207.dp)
                    .size(28.dp, 29.dp),
            )
            // Empty-504:1714-Rectangle 699
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(x = -1.dp, y = 270.dp)
                    .advancedShadow(color = Color(0x3f000000), alpha = 0.25f, cornersRadius = 10.dp, shadowBlurRadius = 4.dp, offsetX = 0.dp, offsetY = 4.dp)
                    .background(Color(0xffffd166), RoundedCornerShape(10.dp))
                    .size(304.dp, 78.dp),
            )
            // Text-504:1715-Compañerismo
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentSize()
                    .offset(x = 91.dp, y = 280.dp),
                text = "Compañerismo",
                color = Color(0xff000000),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
            // Text-504:1716-Utiliza la ayuda de wooper en un nivel
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentHeight()
                    .offset(x = 96.dp, y = 300.dp)
                    .width(172.dp),
                text = "Utiliza la ayuda de wooper en un  nivel",
                color = Color(0xff000000),
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
            // Text-504:1717-20
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentSize()
                    .offset(x = 278.dp, y = 331.dp),
                text = "20",
                color = Color(0xff000000),
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
            // Image-504:1718-1664374 14
            Image(
                painter = painterResource(id = R.drawable.image7_5041718),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 268.dp, y = 332.dp)
                    .size(8.dp, 9.dp),
            )
            // Empty-504:1719-Rectangle 700
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 0.dp, y = 270.dp)
                    .background(Color(0xff605e5e))
                    .size(80.dp, 78.dp),
            )
            // Image-504:1720-747305 9
            Image(
                painter = painterResource(id = R.drawable.image8_5041720),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 26.dp, y = 297.dp)
                    .size(28.dp, 29.dp),
            )
            // Empty-504:1737-Rectangle 705
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(x = -1.dp, y = 550.dp)
                    .advancedShadow(color = Color(0x3f000000), alpha = 0.25f, cornersRadius = 10.dp, shadowBlurRadius = 4.dp, offsetX = 0.dp, offsetY = 4.dp)
                    .background(Color(0xffffd166), RoundedCornerShape(10.dp))
                    .size(304.dp, 78.dp),
            )
            // Text-504:1738-Compañerismo
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentSize()
                    .offset(x = 91.dp, y = 560.dp)
                    .border(0.5.dp, Color(0xff000000)),
                text = "Compañerismo",
                color = Color(0xff000000),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
            // Text-504:1739-Utiliza la ayuda de wooper en un nivel
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentHeight()
                    .offset(x = 96.dp, y = 580.dp)
                    .width(172.dp),
                text = "Utiliza la ayuda de wooper en un  nivel",
                color = Color(0xff000000),
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
            // Text-504:1740-20
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentSize()
                    .offset(x = 278.dp, y = 611.dp),
                text = "20",
                color = Color(0xff000000),
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
            // Image-504:1741-1664374 17
            Image(
                painter = painterResource(id = R.drawable.image9_5041741),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 268.dp, y = 612.dp)
                    .size(8.dp, 9.dp),
            )
            // Empty-504:1742-Rectangle 706
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 0.dp, y = 550.dp)
                    .background(Color(0xff605e5e))
                    .size(80.dp, 78.dp),
            )
            // Image-504:1743-747305 12
            Image(
                painter = painterResource(id = R.drawable.image10_5041743),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 26.dp, y = 577.dp)
                    .size(28.dp, 29.dp),
            )
            // Empty-504:1744-Rectangle 707
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(x = -1.dp, y = 640.dp)
                    .advancedShadow(color = Color(0x3f000000), alpha = 0.25f, cornersRadius = 10.dp, shadowBlurRadius = 4.dp, offsetX = 0.dp, offsetY = 4.dp)
                    .background(Color(0xffffd166), RoundedCornerShape(10.dp))
                    .size(304.dp, 78.dp),
            )
            // Text-504:1745-Compañerismo
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentSize()
                    .offset(x = 91.dp, y = 650.dp)
                    .border(0.5.dp, Color(0xff000000)),
                text = "Compañerismo",
                color = Color(0xff000000),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
            // Text-504:1746-Utiliza la ayuda de wooper en un nivel
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentHeight()
                    .offset(x = 96.dp, y = 670.dp)
                    .width(172.dp),
                text = "Utiliza la ayuda de wooper en un  nivel",
                color = Color(0xff000000),
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
            // Text-504:1747-20
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentSize()
                    .offset(x = 278.dp, y = 701.dp),
                text = "20",
                color = Color(0xff000000),
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
            // Image-504:1748-1664374 18
            Image(
                painter = painterResource(id = R.drawable.image11_5041748),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 268.dp, y = 702.dp)
                    .size(8.dp, 9.dp),
            )
            // Empty-504:1749-Rectangle 708
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 0.dp, y = 640.dp)
                    .background(Color(0xff605e5e))
                    .size(80.dp, 78.dp),
            )
            // Image-504:1750-747305 13
            Image(
                painter = painterResource(id = R.drawable.image12_5041750),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 26.dp, y = 667.dp)
                    .size(28.dp, 29.dp),
            )
            // Empty-504:1722-Rectangle 701
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(x = -1.dp, y = 365.dp)
                    .advancedShadow(color = Color(0x3f000000), alpha = 0.25f, cornersRadius = 10.dp, shadowBlurRadius = 4.dp, offsetX = 0.dp, offsetY = 4.dp)
                    .background(Color(0xffffd166), RoundedCornerShape(10.dp))
                    .size(304.dp, 78.dp),
            )
            // Text-504:1723-Compañerismo
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentSize()
                    .offset(x = 91.dp, y = 375.dp),
                text = "Compañerismo",
                color = Color(0xff000000),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
            // Text-504:1724-Utiliza la ayuda de wooper en un nivel
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentHeight()
                    .offset(x = 96.dp, y = 395.dp)
                    .width(172.dp),
                text = "Utiliza la ayuda de wooper en un  nivel",
                color = Color(0xff000000),
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
            // Text-504:1725-20
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentSize()
                    .offset(x = 278.dp, y = 426.dp),
                text = "20",
                color = Color(0xff000000),
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
            // Image-504:1726-1664374 15
            Image(
                painter = painterResource(id = R.drawable.image13_5041726),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 268.dp, y = 427.dp)
                    .size(8.dp, 9.dp),
            )
            // Empty-504:1727-Rectangle 702
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 0.dp, y = 365.dp)
                    .background(Color(0xff605e5e))
                    .size(80.dp, 78.dp),
            )
            // Image-504:1728-747305 10
            Image(
                painter = painterResource(id = R.drawable.image14_5041728),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 26.dp, y = 392.dp)
                    .size(28.dp, 29.dp),
            )
            // Empty-504:1729-Rectangle 703
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(x = -1.dp, y = 455.dp)
                    .advancedShadow(color = Color(0x3f000000), alpha = 0.25f, cornersRadius = 10.dp, shadowBlurRadius = 4.dp, offsetX = 0.dp, offsetY = 4.dp)
                    .background(Color(0xffffd166), RoundedCornerShape(10.dp))
                    .size(304.dp, 78.dp),
            )
            // Text-504:1730-Compañerismo
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentSize()
                    .offset(x = 91.dp, y = 465.dp),
                text = "Compañerismo",
                color = Color(0xff000000),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
            // Text-504:1731-Utiliza la ayuda de wooper en un nivel
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentHeight()
                    .offset(x = 96.dp, y = 485.dp)
                    .width(172.dp),
                text = "Utiliza la ayuda de wooper en un  nivel",
                color = Color(0xff000000),
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
            // Text-504:1732-20
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentSize()
                    .offset(x = 278.dp, y = 516.dp),
                text = "20",
                color = Color(0xff000000),
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
            // Image-504:1733-1664374 16
            Image(
                painter = painterResource(id = R.drawable.image15_5041733),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 268.dp, y = 517.dp)
                    .size(8.dp, 9.dp),
            )
            // Empty-504:1734-Rectangle 704
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 0.dp, y = 455.dp)
                    .background(Color(0xff605e5e))
                    .size(80.dp, 78.dp),
            )
            // Image-504:1735-747305 11
            Image(
                painter = painterResource(id = R.drawable.image16_5041735),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 26.dp, y = 482.dp)
                    .size(28.dp, 29.dp),
            )
        }


    }
}

@Preview(showBackground = true)
@Composable
fun CodiaMainViewPreview() {
    Wooperland_enserioTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val scrollState = rememberScrollState()
            Column(modifier = Modifier.verticalScroll(scrollState)) {
                LoginScreen()
            }
        }
    }
}