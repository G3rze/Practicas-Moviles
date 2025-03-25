package com.gerze.cuadrante

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.text.style.TextAlign.Companion.Justify
import androidx.compose.ui.unit.dp
import com.gerze.cuadrante.ui.theme.CuadranteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CuadranteTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ColumnContent(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Content(title: String, content: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier.padding(16.dp), contentAlignment = Alignment.Center) {
        Column (horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp),
                textAlign = Center,
            )
            Text(
                text = content,
                textAlign = Justify,
            )
        }
    }
}

@Composable
fun RowContent (title1: String, content1: String, title2: String, content2: String, modifier: Modifier = Modifier, modifier1: Modifier = Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Content(title = title1, content = content1, modifier.fillMaxHeight())
        Content(title = title2, content = content2, modifier1.fillMaxHeight())
    }
}

@Composable
fun ColumnContent (modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Column {
            RowContent(
                title1 = "Text composable",
                content1 = "Displays text and follows the recommended Material Design guidelines.",
                title2 = "Image composable",
                content2 = "Creates a composable that lays out and draws a given Painter class object.",
                modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFEADDFF)),
                modifier1 = Modifier
                    .weight(1f)
                    .background(Color(0xFFD0BCFF))
            )
            RowContent(
                title1 = "Row composable",
                content1 = "A layout composable that places its children in a horizontal sequence.",
                title2 = "Column composable",
                content2 = "A layout composable that places its children in a vertical sequence.",
                modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFB69DF8)),
                modifier1 = Modifier
                    .weight(1f)
                    .background(Color(0xFFF6EDFF))
            )
        }
    }
}

