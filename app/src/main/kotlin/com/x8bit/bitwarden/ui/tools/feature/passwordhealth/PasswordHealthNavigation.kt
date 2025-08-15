package com.x8bit.bitwarden.ui.tools.feature.passwordhealth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

/**
 * The type-safe route for the password health screen.
 */
@Serializable
object PasswordHealthRoute

/**
 * Adds the password health destination to the navigation graph.
 */
fun NavGraphBuilder.passwordHealthDestination(
    onNavigateBack: () -> Unit,
) {
    composable<PasswordHealthRoute> {
        PasswordHealthScreen(
            onNavigateBack = onNavigateBack,
        )
    }
}

/**
 * Navigates to the password health screen.
 */
fun NavController.navigateToPasswordHealth(navOptions: NavOptions? = null) {
    navigate(PasswordHealthRoute, navOptions)
}
