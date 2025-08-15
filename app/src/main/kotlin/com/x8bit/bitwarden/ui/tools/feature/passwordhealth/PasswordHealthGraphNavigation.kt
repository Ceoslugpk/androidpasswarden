package com.x8bit.bitwarden.ui.tools.feature.passwordhealth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.navigation
import kotlinx.serialization.Serializable

/**
 * The type-safe route for the password health graph.
 */
@Serializable
data object PasswordHealthGraphRoute

/**
 * Adds the password health graph to the navigation graph.
 */
fun NavGraphBuilder.passwordHealthGraph(
    onNavigateBack: () -> Unit,
) {
    navigation<PasswordHealthGraphRoute>(
        startDestination = PasswordHealthRoute,
    ) {
        passwordHealthDestination(
            onNavigateBack = onNavigateBack,
        )
    }
}

/**
 * Navigates to the password health graph.
 */
fun NavController.navigateToPasswordHealthGraph(navOptions: NavOptions? = null) {
    this.navigate(route = PasswordHealthGraphRoute, navOptions = navOptions)
}
