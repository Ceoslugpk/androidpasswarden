package com.x8bit.bitwarden.ui.platform.feature.settings.digitallegacy

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DigitalLegacyViewModel @Inject constructor() : ViewModel() {

    fun saveTrustedContact(email: String) {
        println("Trusted contact email: $email")
    }
}
