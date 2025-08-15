package com.x8bit.bitwarden.data.tools.passwordhealth.repository

import com.x8bit.bitwarden.data.vault.manager.model.VaultCipher
import kotlinx.coroutines.flow.Flow

/**
 * Repository for the Password Health feature.
 */
interface PasswordHealthRepository {

    /**
     * A flow of all vault ciphers.
     */
    val vaultCiphers: Flow<List<VaultCipher>>
}
