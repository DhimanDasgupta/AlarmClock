package com.dhimandasgupta.alarmclock.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dhimandasgupta.alarmclock.*

@Preview(showBackground = true)
@Composable
fun EmptyAlarmPane(
    modifier: Modifier = Modifier,
    navigateToSetAlarm: () -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier.weight(1f)
        )

        Icon(
            modifier = Modifier
                .size(64.dp)
                .clickable { navigateToSetAlarm },
            painter = painterResource(R.drawable.alarm),
            tint = colorResource(R.color.splash_blue),
            contentDescription = "Alarm Icon"
        )

        Text(
            text = "Your alarms are empty! Please set your first alarm so that you do not miss the important moment.",
            modifier = Modifier.padding(all = 16.dp)
        )

        Spacer(
            modifier = Modifier.weight(1f)
        )

        FloatingActionButton(
            onClick = { navigateToSetAlarm() },
            modifier = Modifier.padding(all = 32.dp).size(64.dp),
            shape = CircleShape
        ) {
            Text(
                text = "+",
                fontWeight = FontWeight.SemiBold,
                style = typography.headlineLarge,
                color = colorScheme.onBackground,
            )
        }
    }
}