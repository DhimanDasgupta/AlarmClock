package com.dhimandasgupta.alarmclock.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dhimandasgupta.alarmclock.*

@Preview(showBackground = true)
@Composable
fun EmptyAlarmPane(
    modifier: Modifier = Modifier,
    navigateToRingtonePicker: (String?, String?) -> Unit = { _, _ -> }
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier
                .size(64.dp)
                .clickable { navigateToRingtonePicker("name", "uri") },
            painter = painterResource(R.drawable.alarm),
            tint = colorResource(R.color.splash_blue),
            contentDescription = "Alarm Icon"
        )

        Text(
            text = "Your alarms are empty! Please set your first alarm so that you do not miss the important moment.",
            modifier = Modifier.padding(all = 16.dp)
        )
    }
}