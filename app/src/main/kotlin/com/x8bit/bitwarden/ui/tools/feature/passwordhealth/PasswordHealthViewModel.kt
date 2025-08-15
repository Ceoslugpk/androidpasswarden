package com.x8bit.bitwarden.ui.tools.feature.passwordhealth

import com.x8bit.bitwarden.data.tools.passwordhealth.repository.PasswordHealthRepository
import com.x8bit.bitwarden.data.vault.manager.model.VaultCipher
import com.x8bit.bitwarden.ui.platform.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

/**
 * ViewModel for the Password Health screen.
 */
@HiltViewModel
class PasswordHealthViewModel @Inject constructor(
    passwordHealthRepository: PasswordHealthRepository,
) : BaseViewModel<PasswordHealthState, Unit, Unit>(
    initialState = PasswordHealthState(),
) {
    val state: StateFlow<PasswordHealthState> = passwordHealthRepository.vaultCiphers
        .map { ciphers ->
            val reusedPasswords = ciphers
                .filterIsInstance<VaultCipher.Login>()
                .groupBy { it.password }
                .filter { it.value.size > 1 }
                .values
                .flatten()

            val weakPasswords = ciphers
                .filterIsInstance<VaultCipher.Login>()
                .filter { it.password.length < 8 }

            val oldPasswords = ciphers
                .filterIsInstance<VaultCipher.Login>()
                // TODO: Define what "old" means
                .filter { false }

            PasswordHealthState(
                reusedPasswords = reusedPasswords,
                weakPasswords = weakPasswords,
                oldPasswords = oldPasswords,
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = PasswordHealthState(),
        )

    override fun handleAction(action: Unit) {
        // TODO: Implement
    }
}

data class PasswordHealthState(
    val reusedPasswords: List<VaultCipher.Login> = emptyList(),
    val weakPasswords: List<VaultCipher.Login> = emptyList(),
    val oldPasswords: List<VaultCipher.Login> = emptyList(),
)
