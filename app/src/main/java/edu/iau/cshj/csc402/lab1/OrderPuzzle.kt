package edu.iau.cshj.csc402.lab1

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val MintGreen = Color(0xFF3DDC84)

@Composable
fun ChainA(modifier: Modifier = Modifier) {
    Text(
        text = "content",
        modifier = modifier
            .background(MintGreen)
            .padding(24.dp)
    )
}

@Composable
fun ChainB(modifier: Modifier = Modifier) {
    Text(
        text = "content",
        modifier = modifier
            .padding(24.dp)
            .background(MintGreen)
    )
}

@Composable
fun ChainC(modifier: Modifier = Modifier) {
    Text(
        text = "content",
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(MintGreen)
    )
}

@Composable
fun ClickableBeforePadding() {
    Text(
        text = "Clickable before Padding",
        modifier = Modifier
            .background(Color.LightGray)
            .clickable { /* Tap action */ }
            .padding(16.dp)
    )
}

@Composable
fun PaddingBeforeClickable() {
    Text(
        text = "Padding before Clickable",
        modifier = Modifier
            .background(Color.LightGray)
            .padding(16.dp)
            .clickable { /* Tap action */ }
    )
}

@Preview(showBackground = true)
@Composable
fun OrderPuzzlePreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ChainA()
        ChainB()
        ChainC()

        Spacer(modifier = Modifier.height(20.dp))

        ClickableBeforePadding()
        PaddingBeforeClickable()
    }
}