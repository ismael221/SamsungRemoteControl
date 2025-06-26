package com.ismael.samsung.remote.control.ui.screen

import androidx.compose.foundation.background
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ismael.samsung.remote.control.R
import com.ismael.samsung.remote.control.viewmodel.RemoteControlViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RemoteControlApp(
    modifier: Modifier = Modifier
) {
    val viewModel: RemoteControlViewModel = viewModel()
    var ipTv by remember { mutableStateOf("192.168.100.14") }

    viewModel.conectarComTv(ipTv)

    Column(
        modifier = modifier
            .background(Color.Companion.Black)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {
            IconButton(
                onClick = {
                    viewModel.enviarComando("KEY_POWER")
                },
                modifier = Modifier
                    .background(
                        Color.Companion.DarkGray,
                        ShapeDefaults.Medium
                    )
                    .padding(16.dp)
                    .size(size = 32.dp),
            ) {
                Icon(
                    painter = painterResource(R.drawable.power_settings_new_24px),
                    tint = Color.Companion.Red,
                    contentDescription = null,
                    modifier = Modifier
                        .background(
                            Color.Companion.DarkGray,
                            ShapeDefaults.Medium
                        )
                        .size(32.dp),
                )
            }

            Spacer(
                modifier = Modifier.weight(
                    1f
                )
            )

            IconButton(
                onClick = {},
                modifier = Modifier
                    .background(
                        Color.Companion.DarkGray,
                        ShapeDefaults.Medium
                    )
                    .padding(16.dp)
                    .size(32.dp),
            ) {
                Icon(
                    painter = painterResource(R.drawable.tune_24px),
                    tint = Color.Companion.White,
                    contentDescription = null,
                    modifier = Modifier
                        .background(
                            Color.DarkGray,
                            ShapeDefaults.Medium
                        )
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
                    onClick = {
                        viewModel.enviarComando("KEY_MUTE")
                    },
                    modifier = Modifier
                        .background(
                            Color.Companion.DarkGray,
                            ShapeDefaults.Medium
                        )
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
                        .background(
                            Color.DarkGray,
                            CircleShape
                        )
                        .size(112.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .padding(4.dp)
                    ) {
                        Text(
                            text = "1 2 3",
                            color = Color.White,
                            fontWeight = FontWeight.Companion.Bold,
                            modifier = Modifier.Companion
                        )
                    }
                }
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Companion.End,
                modifier = Modifier.Companion
                    .weight(1f)
            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier.Companion
                        .background(
                            Color.Companion.DarkGray,
                            ShapeDefaults.Medium
                        )
                        .width(96.dp)
                        .padding(16.dp)
                        .size(32.dp),
                ) {
                    Text(
                        text = "MENU",
                        color = Color.Companion.White,
                        fontWeight = FontWeight.Companion.Bold,
                        modifier = Modifier.Companion
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
                    onClick = {
                        viewModel.enviarComando("KEY_VOLUP")
                    },
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
                    onClick = {
                        viewModel.enviarComando("KEY_VOLDOWN")
                    },
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
                    .padding(16.dp)
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

                Text(
                    text = "CH",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(8.dp, 50.dp, 8.dp, 32.dp)
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
        }

        Row(
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
                        painter = painterResource(R.drawable.reply_24px),
                        tint = Color.White,
                        contentDescription = null,
                        modifier = Modifier
                            .size(32.dp),
                    )
                }
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
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
                        painter = painterResource(R.drawable.home_24px),
                        tint = Color.White,
                        contentDescription = null,
                        modifier = Modifier
                            .size(32.dp),
                    )
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
                    Icon(
                        painter = painterResource(R.drawable.logout_24px),
                        tint = Color.White,
                        contentDescription = null,
                        modifier = Modifier
                            .size(32.dp),
                    )
                }
            }
        }

        Row(
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
                        painter = painterResource(R.drawable.netflix),
                        tint = Color.White,
                        contentDescription = null,
                        modifier = Modifier
                            .size(70.dp),
                    )
                }
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
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
                        painter = painterResource(R.drawable.prime),
                        tint = Color.White,
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp),
                    )
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
                    Icon(
                        painter = painterResource(R.drawable.globo),
                        tint = Color.White,
                        contentDescription = null,
                        modifier = Modifier
                            .size(150.dp),
                    )
                }
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(8.dp)
            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .background(Color.DarkGray, CircleShape)
                        .size(70.dp),
                ) {
                    Icon(
                        painter = painterResource(R.drawable.skip_previous_24px),
                        tint = Color.White,
                        contentDescription = null,
                        modifier = Modifier
                            .size(32.dp),
                    )
                }
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(8.dp)
            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .background(Color.DarkGray, CircleShape)
                        .size(90.dp),
                ) {
                    Icon(
                        painter = painterResource(R.drawable.pause_24px),
                        tint = Color.White,
                        contentDescription = null,
                        modifier = Modifier
                            .size(32.dp),
                    )
                }
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .padding(8.dp)
            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .background(Color.DarkGray, CircleShape)
                        .size(70.dp),
                ) {
                    Icon(
                        painter = painterResource(R.drawable.skip_next_24px),
                        tint = Color.White,
                        contentDescription = null,
                        modifier = Modifier
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
        modifier = Modifier.Companion
            .size(200.dp)
            .background(Color.Companion.DarkGray, shape = CircleShape)
    ) {
        IconButton(
            modifier = Modifier.Companion
                .align(Alignment.Companion.TopCenter)
                .padding(top = 16.dp),
            onClick = {}
        ) {
            Text(
                text = "▲",
                color = Color.Companion.LightGray,
                modifier = Modifier.Companion
            )
        }

        IconButton(
            modifier = Modifier.Companion
                .align(Alignment.Companion.BottomCenter)
                .padding(bottom = 16.dp),
            onClick = {}
        ) {
            Text(
                text = "▼",
                color = Color.Companion.LightGray,
                modifier = Modifier.Companion

            )
        }

        IconButton(
            modifier = Modifier.Companion
                .align(Alignment.Companion.CenterStart)
                .padding(start = 16.dp),
            onClick = {}
        ) {
            Text(
                text = "◀",
                color = Color.Companion.LightGray,
                modifier = Modifier.Companion
            )
        }

        IconButton(
            modifier = Modifier.Companion
                .align(Alignment.Companion.CenterEnd)
                .padding(end = 16.dp),
            onClick = {}
        ) {
            Text(
                text = "▶",
                color = Color.Companion.LightGray,
            )
        }

        IconButton(
            modifier = Modifier.Companion.align(Alignment.Companion.Center),
            onClick = {}
        ) {
            Text(
                text = "OK",
                color = Color.Companion.White,
                fontSize = 18.sp
            )
        }
    }
}