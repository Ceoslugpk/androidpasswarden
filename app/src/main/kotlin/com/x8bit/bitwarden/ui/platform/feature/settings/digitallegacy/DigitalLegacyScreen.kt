package com.x8bit.bitwarden.ui.platform.feature.settings.digitallegacy

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bitwarden.ui.platform.components.appbar.BitwardenMediumTopAppBar
import com.bitwarden.ui.platform.components.appbar.NavigationIcon
import com.bitwarden.ui.platform.components.button.BitwardenFilledButton
import com.bitwarden.ui.platform.components.field.BitwardenTextField
import com.bitwarden.ui.platform.components.scaffold.BitwardenScaffold
import com.bitwarden.ui.platform.resource.BitwardenDrawable
import com.bitwarden.ui.platform.resource.BitwardenString

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DigitalLegacyScreen(
    onNavigateBack: () -> Unit,
    viewModel: DigitalLegacyViewModel = hiltViewModel(),
) {
    var trustedContactEmail by remember { mutableStateOf("") }

    BitwardenScaffold(
        topBar = {
            BitwardenMediumTopAppBar(
                title = stringResource(id = BitwardenString.digital_legacy),
                navigationIcon = NavigationIcon(
                    navigationIcon = rememberVectorPainter(id = BitwardenDrawable.ic_back),
                    navigationIconContentDescription = stringResource(id = BitwardenString.back),
                    onNavigationIconClick = onNavigateBack,
                ),
            )
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            Text(text = stringResource(id = BitwardenString.digital_legacy_description))
            Spacer(modifier = Modifier.height(16.dp))
            BitwardenTextField(
                value = trustedContactEmail,
                onValueChange = { trustedContactEmail = it },
                label = { Text(text = stringResource(id = BitwardenString.trusted_contact_email)) },
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(16.dp))
            BitwardenFilledButton(
                text = stringResource(id = BitwardenString.save),
                onClick = {
                    viewModel.saveTrustedContact(trustedContactEmail)
                },
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}
