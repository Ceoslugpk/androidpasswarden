package com.x8bit.bitwarden.ui.tools.feature.passwordhealth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.x8bit.bitwarden.ui.vault.feature.vault.VaultListItem

/**
 * The Password Health screen.
 *
 * @param onNavigateBack Callback to navigate back to the previous screen.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordHealthScreen(
    onNavigateBack: () -> Unit,
    viewModel: PasswordHealthViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Password Health") },
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
        ) {
            LazyColumn {
                if (state.reusedPasswords.isNotEmpty()) {
                    item {
                        Text("Reused Passwords")
                    }
                    items(state.reusedPasswords) { cipher ->
                        VaultListItem(
                            cipher = cipher,
                            onCipherClick = {},
                            onFavoriteClick = {},
                            onLongClick = {},
                        )
                    }
                }

                if (state.weakPasswords.isNotEmpty()) {
                    item {
                        Text("Weak Passwords")
                    }
                    items(state.weakPasswords) { cipher ->
                        VaultListItem(
                            cipher = cipher,
                            onCipherClick = {},
                            onFavoriteClick = {},
                            onLongClick = {},
                        )
                    }
                }
            }
        }
    }
}
