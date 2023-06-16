package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeImgAndText(
    modifier: Modifier = Modifier,
    imageResource: Int,
    textResource: Int,
    onImageClick: () -> Unit,
) {
    Box(modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = onImageClick,
                shape = RoundedCornerShape(10),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xffC3ECD2)
                )
            ) {
                Image(
                    painter = painterResource(imageResource),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(textResource),
            )
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun LemonadeApp() {

    var currSlide by remember {
        mutableStateOf(1)
    }

    var squeezeCount by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xffF9E44C)
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
        ) {
            when (currSlide) {
                1 -> {
                    LemonadeImgAndText(
                        imageResource = R.drawable.lemon_tree,
                        textResource = R.string.lemon_tree_text,
                        onImageClick = {
                            currSlide = 2
                            squeezeCount = (2..4).random()
                        }
                    )
                }

                2 -> {
                    LemonadeImgAndText(
                        imageResource = R.drawable.lemon_squeeze,
                        textResource = R.string.lemon_img_text,
                        onImageClick = {
                            squeezeCount--
                            if (squeezeCount == 0) currSlide = 3
                        }
                    )
                }

                3 -> {
                    LemonadeImgAndText(
                        imageResource = R.drawable.lemon_drink,
                        textResource = R.string.lemon_drink_text,
                        onImageClick = {
                            currSlide = 4
                        }
                    )
                }

                4 -> {
                    LemonadeImgAndText(
                        imageResource = R.drawable.lemon_restart,
                        textResource = R.string.lemon_empty_text,
                        onImageClick = {
                            currSlide = 1
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LemonadePreview() {
    LemonadeAppTheme {
        LemonadeApp()
    }
}