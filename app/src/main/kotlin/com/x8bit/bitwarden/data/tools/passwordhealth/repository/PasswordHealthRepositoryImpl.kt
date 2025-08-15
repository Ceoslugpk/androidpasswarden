package com.x8bit.bitwarden.data.tools.passwordhealth.repository

import com.x8bit.bitwarden.data.vault.manager.model.VaultCipher
import com.x8bit.bitwarden.data.vault.repository.VaultRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Implementation of [PasswordHealthRepository].
 */
class PasswordHealthRepositoryImpl @Inject constructor(
    private val vaultRepository: VaultRepository,
) : PasswordHealthRepository {

    override val vaultCiphers: Flow<List<VaultCipher>> = vaultRepository.vaultCiphers
}
