package com.dhimandasgupta.alarmclock.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun AlarmPane(
    modifier: Modifier = Modifier,
    navigateToAlarmId: (String) -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Your Alarms",
                style = MaterialTheme.typography.headlineLarge,
                color = colorScheme.onBackground,
                modifier = Modifier
                    .background(
                        color = colorScheme.background.copy(alpha = 0.25f),
                        shape = CardDefaults.shape
                    )
                    .clickable { navigateToAlarmId("some id") }
                    .padding(horizontal = 8.dp)
            )
        }
        items(10) {
            AlarmItem()
        }
    }
}

@Composable
private fun AlarmItem() {
    Card(
        modifier = Modifier
            .wrapContentSize()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
            ) {
                Text(
                    text = "Alarm 1",
                    style = MaterialTheme.typography.labelLarge,
                    color = colorScheme.onBackground,
                )
                Switch(
                    checked = true,
                    onCheckedChange = {_ -> false}
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
            ) {
                Text(
                    text = "10:00",
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.headlineLarge,
                    color = colorScheme.onBackground,
                )

                Text(
                    text = "AM",
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.labelSmall,
                    color = colorScheme.onBackground
                )
            }

            Text(
                text = "Alarm in 30 mins",
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.labelSmall,
                color = colorScheme.onBackground,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            )

            FlowRow(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(0.dp),
                verticalArrangement = Arrangement.Center
            ) {
                AssistChip(
                    onClick = {},
                    label = {
                        Text("M")
                    },
                    enabled = true,
                    shape = CircleShape
                )
                AssistChip(
                    onClick = {},
                    label = {
                        Text("T")
                    },
                    enabled = false,
                    shape = CircleShape
                )
                AssistChip(
                    onClick = {},
                    label = {
                        Text("W")
                    },
                    enabled = false,
                    shape = CircleShape
                )
                AssistChip(
                    onClick = {},
                    label = {
                        Text("T")
                    },
                    enabled = true,
                    shape = CircleShape,
                    modifier = Modifier.padding(1.dp)
                )
                AssistChip(
                    onClick = {},
                    label = {
                        Text("F")
                    },
                    enabled = false,
                    shape = CircleShape
                )
                AssistChip(
                    onClick = {},
                    label = {
                        Text("S")
                    },
                    enabled = true,
                    shape = CircleShape
                )
                AssistChip(
                    onClick = {},
                    label = {
                        Text("S")
                    },
                    enabled = true,
                    shape = CircleShape,
                    modifier = Modifier.padding(1.dp)
                )
            }

            Text(
                text = "Go to bed at 02:00Am ti get 8h of sleep",
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.bodyMedium,
                color = colorScheme.onBackground,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 8.dp)
            )
        }
    }
}