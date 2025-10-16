package com.kata.tictactoe.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.kata.tictactoe.R

@Composable
fun ShowAlertDialog(msg: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AlertDialog(
            onDismissRequest = {
                onClick.invoke()
            },
            title = {
                Text(text = stringResource(R.string.app_name))
            },
            text = {
                Text(msg)
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onClick.invoke()
                    }
                ) {
                    Text("OK")
                }
            }
        )
    }
}