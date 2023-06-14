package com.example.myarticle

import android.os.Bundle
import android.preference.PreferenceActivity.Header
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myarticle.ui.theme.MyArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Article(

                    )
                }
            }
        }
    }
}

@Composable
fun Article(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        HeaderImage()
        ArticleContent()
    }
}

@Composable
fun HeaderImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.header_image)
    Image(
        painter = image,
        contentDescription = null
    )
}

@Composable
fun ArticleContent(modifier: Modifier = Modifier) {

        Text(
            text = stringResource(R.string.article_title),
            modifier = modifier.padding(16.dp),
            textAlign = TextAlign.Justify,
            fontSize = 24.sp
        )
        Text(
            text = stringResource(R.string.article_hero),
            modifier = modifier.padding(horizontal = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = stringResource(R.string.article_text),
            modifier = modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyArticleTheme {
        Article()
    }
}