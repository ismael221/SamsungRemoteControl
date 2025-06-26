package com.ismael.samsung.remote.control

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ismael.samsung.remote.control.ui.theme.SamsungRemoteControlTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SamsungRemoteControlTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val windowSize = calculateWindowSizeClass(this)
                    RemoteControl(
                        //  windowSize = windowSize.widthSizeClass,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun RemoteControl(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .background(Color.DarkGray, ShapeDefaults.Medium)
                    .padding(16.dp)
                    .size(32.dp),
            ) {
                Icon(
                    painter = painterResource(R.drawable.power_settings_new_24px),
                    tint = Color.Red,
                    contentDescription = null,
                    modifier = Modifier
                        .background(Color.DarkGray, ShapeDefaults.Medium)
                        .size(32.dp),
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            IconButton(
                onClick = {},
                modifier = Modifier
                    .background(Color.DarkGray, ShapeDefaults.Medium)
                    .padding(16.dp)
                    .size(32.dp),
            ) {
                Icon(
                    painter = painterResource(R.drawable.tune_24px),
                    tint = Color.White,
                    contentDescription = null,
                    modifier = Modifier
                        .background(Color.DarkGray, ShapeDefaults.Medium)
                        .size(32.dp),
                )
            }

        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .background(Color.DarkGray, ShapeDefaults.Medium)
                        .width(96.dp)
                        .padding(16.dp)
                        .size(32.dp),
                ) {
                    Icon(
                        painter = painterResource(R.drawable.no_sound_24px),
                        tint = Color.White,
                        contentDescription = null,
                        modifier = Modifier
                            .size(32.dp),
                    )
                }
            }

            Column(
                modifier = Modifier
            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .background(Color.DarkGray, CircleShape)
                        .size(112.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .padding(4.dp)
                    ) {
                        Text(
                            text = "1 2 3",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                        )
                    }
                }
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .weight(1f)
            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .background(Color.DarkGray, ShapeDefaults.Medium)
                        .width(96.dp)
                        .padding(16.dp)
                        .size(32.dp),
                ) {
                    Text(
                        text = "MENU",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .weight(1f)
            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .background(Color.DarkGray, ShapeDefaults.Medium)
                        .padding(16.dp)
                        .size(32.dp),
                ) {
                    Icon(
                        painter = painterResource(R.drawable.add_24px),
                        tint = Color.White,
                        contentDescription = null,
                        modifier = Modifier
                            .background(Color.DarkGray, ShapeDefaults.Medium)
                            .size(32.dp),
                    )
                }

                Icon(
                    painter = painterResource(R.drawable.volume_up_24px),
                    tint = Color.White,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp, 32.dp, 8.dp, 32.dp)
                        .size(44.dp)
                )

                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .background(Color.DarkGray, ShapeDefaults.Medium)
                        .padding(16.dp)
                        .size(32.dp),
                ) {
                    Icon(
                        painter = painterResource(R.drawable.remove_24px),
                        tint = Color.White,
                        contentDescription = null,
                        modifier = Modifier
                            .background(Color.DarkGray, ShapeDefaults.Medium)
                            .size(32.dp),
                    )
                }
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
            ) {
                CircularDPad()
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .weight(1f)
            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .background(Color.DarkGray, ShapeDefaults.Medium)
                        .padding(16.dp)
                        .size(32.dp),
                ) {
                    Icon(
                        painter = painterResource(R.drawable.add_24px),
                        tint = Color.White,
                        contentDescription = null,
                        modifier = Modifier
                            .background(Color.DarkGray, ShapeDefaults.Medium)
                            .size(32.dp),
                    )
                }
            }
        }

    }
}

@Composable
fun CircularDPad() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.DarkGray, shape = CircleShape)
    ) {
        IconButton(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 16.dp),
            onClick = {}
        ) {
            Text(
                text = "▲",
                color = Color.LightGray,
                modifier = Modifier
            )
        }

        IconButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            onClick = {}
        ) {
            Text(
                text = "▼",
                color = Color.LightGray,
                modifier = Modifier

            )
        }

        IconButton(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 16.dp),
            onClick = {}
        ) {
            Text(
                text = "◀",
                color = Color.LightGray,
                modifier = Modifier
            )
        }

        IconButton(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 16.dp),
            onClick = {}
        ) {
            Text(
                text = "▶",
                color = Color.LightGray,
            )
        }

        IconButton(
            modifier = Modifier.align(Alignment.Center),
            onClick = {}
        ) {
            Text(
                text = "OK",
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }
}


@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SamsungRemoteControlTheme {

     //  CircularDPad()

        RemoteControl(

        )
    }
}