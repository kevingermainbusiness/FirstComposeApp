package com.example.firstcomposeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.firstcomposeapp.ui.FirstComposeAppTheme
import jp.wasabeef.composable.coil.CoilImage
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    NewsStory()
                }
            }
        }
    }
}

@Composable
fun randomColor(): Color = Color(
        red = Random.nextInt(0, 255),
        green = Random.nextInt(0, 255),
        blue = Random.nextInt(0, 255)
)

@Composable
fun UserPhoto(imageUrl: String, modifier: Modifier) {
    val ringColor = randomColor()
    CoilImage(imageUrl, modifier = modifier
            .size(38.dp).border(2.dp, ringColor, CircleShape).padding(4.dp).clip(CircleShape))
}

@Composable
fun JetChat() {
    Row {
        UserPhoto(
                imageUrl = "https://cdn.theatlantic.com/thumbor/pN25nhF1hatn7QpckNtABKwzmoI=/0x61:1000x624/720x405/media/old_wire/img/upload/2013/03/18/happydog/original.jpg",
                modifier = Modifier
        )
        Column {
            Row {
                Text("Ali Conors")
                Text("3:50PM")
            }
        }
        Column {
            Text(text = "Yeah I've been mainly referring to " + " the JetNews sample")
        }
    }
}

@Composable
fun NewsStory() {
    val image = imageResource(R.drawable.header)
    MaterialTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            val imageModifier = Modifier
                    .preferredHeight(180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp))
            Image(
                    image,
                    modifier = imageModifier,
                    contentScale = ContentScale.Crop
            )
            Spacer(Modifier.preferredHeight(16.dp))
            Text(text = "A day in Shark Fin Cove")
            Text(text = "Davenport, California")
            Text(text = "December 2018")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstComposeAppTheme {
        JetChat()
    }
}