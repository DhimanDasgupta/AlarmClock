package com.dhimandasgupta.alarmclock.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
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
    navigateToSetAlarm: () -> Unit = {},
    navigateToAlarmId: (String) -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item(
            key = "heading"
        ) {
            Text(
                text = "Your Alarms",
                style = typography.headlineLarge,
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

        item(
            key = "add alarm"
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
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
    }
}

@Composable
private fun AlarmItem() {
    Card(
        modifier = Modifier.wrapContentSize()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Alarm 1",
                    style = typography.labelLarge,
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
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "10:00",
                    fontWeight = FontWeight.SemiBold,
                    style = typography.headlineLarge,
                    color = colorScheme.onBackground,
                )

                Text(
                    text = "AM",
                    fontWeight = FontWeight.Medium,
                    style = typography.labelSmall,
                    color = colorScheme.onBackground
                )
            }

            Text(
                text = "Alarm in 30 mins",
                fontWeight = FontWeight.Medium,
                style = typography.labelSmall,
                color = colorScheme.onBackground,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 2.dp)
            )

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                item(key = "monday") {
                    AssistChip(
                        onClick = {},
                        label = {
                            Text("Mon")
                        },
                        enabled = true,
                        shape = CircleShape
                    )
                }

                item(key = "tuesday") {
                    AssistChip(
                        onClick = {},
                        label = {
                            Text("Tue")
                        },
                        enabled = false,
                        shape = CircleShape
                    )
                }

                item(key = "wednesday") {
                    AssistChip(
                        onClick = {},
                        label = {
                            Text("Wed")
                        },
                        enabled = false,
                        shape = CircleShape
                    )
                }

                item(key = "thursday") {
                    AssistChip(
                        onClick = {},
                        label = {
                            Text("Thu")
                        },
                        enabled = true,
                        shape = CircleShape,
                        modifier = Modifier.padding(1.dp)
                    )
                }

                item(key = "friday") {
                    AssistChip(
                        onClick = {},
                        label = {
                            Text("Fri")
                        },
                        enabled = false,
                        shape = CircleShape
                    )
                }

                item(key = "saturday") {
                    AssistChip(
                        onClick = {},
                        label = {
                            Text("Sat")
                        },
                        enabled = true,
                        shape = CircleShape
                    )
                }

                item(key = "sunday") {
                    AssistChip(
                        onClick = {},
                        label = {
                            Text("Sun")
                        },
                        enabled = true,
                        shape = CircleShape,
                        modifier = Modifier.padding(1.dp)
                    )
                }
            }

            Text(
                text = "Go to bed at 02:00Am to get 8h of sleep..",
                fontWeight = FontWeight.Normal,
                style = typography.bodyMedium,
                color = colorScheme.onBackground,
                modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 0.dp)
            )
        }
    }
}