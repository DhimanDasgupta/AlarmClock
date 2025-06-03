package com.dhimandasgupta.alarmclock.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dhimandasgupta.alarmclock.R

@Preview(showBackground = true, backgroundColor = 0xFF4664FF)
@Composable
fun SetAlarmPane(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit = {}
) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp, horizontal = 8.dp),
            navigateUp = navigateUp
        )


    }
}

@Composable
private fun TopAppBar(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit = {}
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            modifier = Modifier
                .clip(CircleShape)
                .size(36.dp)
                .background(color = colorScheme.primaryContainer)
                .clickable(
                    onClick = navigateUp
                ),
            painter = painterResource(R.drawable.subtract),
            contentDescription = "Close",
            tint = colorResource(R.color.splash_blue)
        )

        Text(
            text = "Set your alarm",
            fontWeight = FontWeight.Normal,
            style = typography.headlineLarge,
            color = colorScheme.onBackground,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )

        ElevatedButton(
            modifier = Modifier.wrapContentSize(),
            onClick = {}
        ) {
            Text(
                text = "Save",
                fontWeight = FontWeight.Bold,
                style = typography.labelMedium,
                color = colorScheme.onBackground,
                textAlign = TextAlign.Center,
            )
        }
    }
}