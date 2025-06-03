package com.dhimandasgupta.alarmclock

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.dhimandasgupta.alarmclock.ui.screens.AlarmPane
import com.dhimandasgupta.alarmclock.ui.screens.EmptyAlarmPane
import com.dhimandasgupta.alarmclock.ui.screens.SetAlarmPane
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

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
            navController = navController
        )
    }
}

private fun NavGraphBuilder.AlarmAppNavigationGraph(
    navController: NavHostController
) {
    val navigateToDetails = { alarmId: String? ->
        navController.navigate(AlarmAppDestinations.AlarmDetailDestination(alarmId))
    }

    val navigateToRingtonePicker = { name: String?, uri: String? ->
        navController.navigate(AlarmAppDestinations.RingtonePickerDestination(name, uri))
    }

    val navigateToSetAlarm = {
        navController.navigate(AlarmAppDestinations.SetAlarmDestination)
    }

    val navigateUp = {
        navController.navigateUp()
        Unit
    }

    navigation<AlarmAppDestinations.RootDestination>(
        startDestination = AlarmAppDestinations.AlarmListDestination
    ) {
        composable<AlarmAppDestinations.AlarmListDestination> {
            AlarmPane(
                modifier = Modifier,
                navigateToSetAlarm = navigateToSetAlarm,
                navigateToAlarmId = { id ->
                    navigateToDetails(id)
                }
            )
        }

        composable<AlarmAppDestinations.AlarmDetailDestination> {
            EmptyAlarmPane(
                modifier = Modifier,
                navigateToSetAlarm = navigateToSetAlarm
            )
        }

        composable<AlarmAppDestinations.SetAlarmDestination> {
            SetAlarmPane(
                modifier = Modifier,
                navigateUp = navigateUp
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

    @Serializable
    data object SetAlarmDestination
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedKoinViewModel(
    navController: NavHostController
): T {
    val navGraphRoute = destination.parent?.route ?: koinViewModel<T>()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return koinViewModel<T>(viewModelStoreOwner = parentEntry)
}