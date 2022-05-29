package ru.agladkov.delizioso.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ru.agladkov.delizioso.R
import ru.agladkov.delizioso.ui.theme.AppTheme

@Composable
fun TextInput(
    modifier: Modifier = Modifier,
    header: String,
    textFieldValue: String,
    secureText: Boolean = false,
    enabled: Boolean = true,
    onTextFieldChange: (String) -> Unit
) {
    Column(modifier = modifier) {
        Text(
            text = header,
            color = AppTheme.colors.headerTextColor,
            fontWeight = FontWeight.Medium
        )

        DTextField(
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxWidth()
                .height(50.dp),
            value = textFieldValue,
            enabled = enabled,
            placeholder = header,
            secureText = secureText,
            onValueChange = onTextFieldChange
        )
    }
}