package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color(0xFFD2E8D4))
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BusinessCardHero()
        BusinessCardContacts()
    }
}

@Composable
fun BusinessCardContacts() {
    val myAppIcons = Icons.Rounded
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp) // Add vertical spacing between rows
    ) {
        Row() {
            Icon(
                myAppIcons.Phone,
                contentDescription = "Phone Icon",
                Modifier.padding(end = 5.dp),
                tint = Color(0xFF297F52)
            )
            Text(text = "01 122 334 455")
        }
        Row() {
            Icon(
                myAppIcons.Share, contentDescription = "Share Icon", Modifier.padding(end = 5.dp),
                tint = Color(0xFF297F52)
            )
            Text(text = "@nicanor-jay")
        }
        Row() {
            Icon(
                myAppIcons.Email, contentDescription = "Email Icon", Modifier.padding(end = 5.dp),
                tint = Color(0xFF297F52)
            )
            Text(text = "nic.jay@android.com")
        }
    }
}

@Composable
fun BusinessCardHero() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color(0xFF073042))

        )
        {
            Image(
                painterResource(R.drawable.android_logo),
                contentDescription = "Android Icon",
                Modifier
                    .fillMaxWidth()
            )

        }
        Text(
            text = stringResource(R.string.full_name),
            fontSize = 25.sp,
            modifier = Modifier.padding(top=20.dp)
        )
        Text(
            text = stringResource(R.string.job_title),
            color = Color(0xFF297F52),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top=10.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}