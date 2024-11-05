package com.example.bennysbusinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bennysbusinesscard.ui.theme.BennysBusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BennysBusinessCardTheme {
                Surface {
                    Card()
                }
            }
        }
    }
}

@Composable
fun Card() {
    val color = colorResource(R.color.bg)
    Box(modifier = Modifier.background(color = color).fillMaxSize()) {
        Column {
            Bio()
            Socials()
        }
    }
}

@Composable
fun Bio( modifier: Modifier = Modifier) {
    val img = painterResource(R.drawable.avatar)
    val name = stringResource(R.string.name)
    val position = stringResource(R.string.position)
    val textColor = colorResource(R.color.text)

    Column(
        modifier = Modifier
            .height(700.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = img,
            contentDescription = null,
            modifier = Modifier
                .size(175.dp)
        )
        Text(
            text = name,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.Thin,
            modifier = modifier
        )
        Text(
            text = position,
            textAlign = TextAlign.Center,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = textColor,
            modifier = modifier
        )
    }
}

@Composable
fun Socials() {
    val phoneIcon = painterResource(R.drawable.phone_icon)
    val phoneText = stringResource(R.string.phoneText)
    val shareIcon = painterResource(R.drawable.share_icon)
    val shareText = stringResource(R.string.github)
    val emailIcon = painterResource(R.drawable.email_icon)
    val emailText = stringResource(R.string.email)


    Column (
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .padding(start = 100.dp),
        verticalArrangement = Arrangement.Bottom,
    ){
        SocialsLink(
            icon = phoneIcon,
            link = phoneText,
        )
        SocialsLink(
            icon = shareIcon,
            link = shareText
        )
        SocialsLink(
            icon = emailIcon,
            link = emailText
        )
    }
}

@Composable
fun SocialsLink(icon: Painter, link: String) {
    Row {
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier
                .size(10.dp)
                .align(alignment = Alignment.CenterVertically)
        )
        Text(
            text = link,
            fontSize = 10.sp,
            lineHeight = 20.sp,
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    BennysBusinessCardTheme {
        Card()
    }
}