package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuadrantsApp()
                }
            }
        }
    }
}

@Composable
fun QuadrantsApp() {
    val quad1Text = arrayOf(stringResource(R.string.q1_header), stringResource(R.string.q1_text))
    val quad2Text = arrayOf(stringResource(R.string.q2_header), stringResource(R.string.q2_text))
    val quad3Text = arrayOf(stringResource(R.string.q3_header), stringResource(R.string.q3_text))
    val quad4Text = arrayOf(stringResource(R.string.q4_header), stringResource(R.string.q4_text))
    Quadrants(
        quad1Content = quad1Text,
        quad2Content = quad2Text,
        quad3Content = quad3Text,
        quad4Content = quad4Text,
    )
}

@Composable
fun Quadrants(
    quad1Content: Array<String>,
    quad2Content: Array<String>,
    quad3Content: Array<String>,
    quad4Content: Array<String>,
    modifier: Modifier = Modifier
) {
    Column(Modifier.fillMaxWidth()) {
        Row (Modifier.weight(1f)) {
            Quadrant(quad1Content,  colorResource(R.color.q1_color), Modifier.weight(1f))
            Quadrant(quad2Content, colorResource(R.color.q2_color), Modifier.weight(1f))
        }
        Row (Modifier.weight(1f)) {
            Quadrant(quad3Content, colorResource(R.color.q3_color), Modifier.weight(1f))
            Quadrant(quad4Content, colorResource(R.color.q4_color),Modifier.weight(1f))
        }
    }
}

@Composable
fun Quadrant(content: Array<String>, color: Color ,modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = content[0], Modifier.padding(bottom=16.dp), fontWeight = FontWeight.Bold)
        Text(text = content[1], textAlign = TextAlign.Justify)

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        QuadrantsApp()
    }
}