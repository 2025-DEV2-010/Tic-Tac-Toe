package com.kata.tictactoe.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kata.tictactoe.domain.model.CellState
import com.kata.tictactoe.presentation.viewmodel.GameBoardViewModel

@Composable
fun GameBoardScreen(innerPadding: PaddingValues) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val viewModel = viewModel<GameBoardViewModel>()

        val gameProgressState by viewModel.gameProgressState.collectAsStateWithLifecycle()

        Text(gameProgressState.gameOutComeStatus.name)

        Text(gameProgressState.statusMessage ?: "")

        LazyColumn {
            itemsIndexed(
                items = gameProgressState.playerMovedPositions,
            ) { rowIndex, rowItem ->
                LazyRow {
                    itemsIndexed(
                        items = rowItem,
                    ) { columnIndex, columnItem ->
                        val cellState: CellState = remember {
                            gameProgressState.playerMovedPositions[rowIndex][columnIndex]
                        }
                        CellComponent(cellState) {
                            viewModel.updatePlayMoveStatus(rowIndex, columnIndex)
                        }
                    }
                }
            }
        }

        Button(onClick = {
            viewModel.resetGame()
        }) {
            Text("Reset Game")
        }
    }
}

@Composable
fun CellComponent(item: CellState, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick
    ) {
        Text(item.name)
    }
}