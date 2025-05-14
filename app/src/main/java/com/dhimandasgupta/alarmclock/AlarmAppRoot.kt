package com.dhimandasgupta.alarmclock

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable

@Composable
fun AlarmAppRoot(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = AlarmAppDestinations.RootDestination,
        modifier = modifier
    ) {
        AlarmAppNavigationGraph(
            navController = navController,
            modifier = modifier
        )
    }
}

private fun NavGraphBuilder.AlarmAppNavigationGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val navigateToDetails = { alarmId: String? ->
        navController.navigate(AlarmAppDestinations.AlarmDetailDestination(alarmId))
    }

    val navigateToRingtonePicker = { name: String?, uri: String? ->
        navController.navigate(AlarmAppDestinations.RingtonePickerDestination(name, uri))
    }

    navigation<AlarmAppDestinations.RootDestination>(
        startDestination = AlarmAppDestinations.AlarmListDestination
    ) {
        composable<AlarmAppDestinations.AlarmListDestination> {
            Text(
                text = "This is Alarm List screen",
                modifier = Modifier.clickable { navigateToDetails("alarmId") }
            )
        }

        composable<AlarmAppDestinations.AlarmDetailDestination> {
            Text(
                text = "This is Alarm Detail screen",
                modifier = Modifier.clickable { navigateToRingtonePicker("name", "uri") }
            )
        }

        composable<AlarmAppDestinations.RingtonePickerDestination> {
            Text(
                text = "This is Ringtone Picker screen",
                modifier = Modifier.clickable {
                    repeat(2) {
                        navController.navigateUp()
                    }
                }
            )
        }
    }
}

object AlarmAppDestinations {
    @Serializable
    data object RootDestination

    @Serializable
    data object AlarmListDestination

    @Serializable
    data class AlarmDetailDestination(
        val alarmId: String?
    )

    @Serializable
    data class RingtonePickerDestination(
        val name: String?,
        val uri: String?
    ) {
        fun getNameAndUriAsPair(): Pair<String, String>? {
            return if (name != null && uri != null) {
                Pair(name, uri)
            } else {
                null
            }
        }
    }
}