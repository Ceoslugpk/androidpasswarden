package com.x8bit.bitwarden.data.tools.passwordhealth.di

import com.x8bit.bitwarden.data.tools.passwordhealth.repository.PasswordHealthRepository
import com.x8bit.bitwarden.data.tools.passwordhealth.repository.PasswordHealthRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PasswordHealthModule {

    @Binds
    abstract fun bindPasswordHealthRepository(
        passwordHealthRepositoryImpl: PasswordHealthRepositoryImpl
    ): PasswordHealthRepository
}
