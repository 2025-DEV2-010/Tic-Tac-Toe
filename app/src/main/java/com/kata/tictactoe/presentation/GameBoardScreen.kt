package com.kata.tictactoe.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kata.tictactoe.R
import com.kata.tictactoe.domain.model.CellState
import com.kata.tictactoe.domain.model.GameOutcome
import com.kata.tictactoe.presentation.model.GameProgress
import com.kata.tictactoe.presentation.viewmodel.GameBoardViewModel

@Composable
fun GameBoardScreen(
    innerPadding: PaddingValues,
    viewModel: GameBoardViewModel = viewModel<GameBoardViewModel>()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val gameProgressState by viewModel.gameProgressState.collectAsStateWithLifecycle()

        StatusComponent(gameProgressState) {
            viewModel.resetGame()
        }

        LazyColumn {
            itemsIndexed(
                items = gameProgressState.playerMovedPositions,
            ) { rowIndex, rowItem ->
                LazyRow {
                    itemsIndexed(
                        items = rowItem,
                    ) { columnIndex, columnItem ->
                        val cellState =
                            gameProgressState.playerMovedPositions[rowIndex][columnIndex]

                        CellComponent(cellState) {
                            viewModel.updatePlayMoveStatus(rowIndex, columnIndex)
                        }
                    }
                }
            }
        }

        Button(
            modifier = Modifier.padding(top = 20.dp),
            onClick = {
                viewModel.resetGame()
            }) {
            Text("Reset Game")
        }

        if (gameProgressState.gameOutComeStatus == GameOutcome.WIN) {
            ShowAlertDialog(
                name = gameProgressState.currentMovePlayer.name,
                msg = stringResource(R.string.win_msg, gameProgressState.currentMovePlayer.name)
            ) {
                viewModel.resetGame()
            }
        }
    }
}

@Composable
fun StatusComponent(gameProgressState: GameProgress, onClick: () -> Unit) {
    Text(
        modifier = Modifier.padding(top = 8.dp),
        text = gameProgressState.gameOutComeStatus.name
    )

    val statusMessage = if (gameProgressState.isDraw) {
        ShowAlertDialog(
            name = gameProgressState.currentMovePlayer.name,
            msg = stringResource(R.string.game_draw),
            onClick = onClick
        )
        stringResource(R.string.move_draw)
    } else {
        when (gameProgressState.statusMessage) {
            CellState.X, CellState.EMPTY -> stringResource(R.string.move_playerX)
            CellState.O -> stringResource(R.string.move_playerY)
            CellState.INVALID -> stringResource(R.string.move_invalid)
        }
    }

    Text(
        modifier = Modifier.padding(top = 8.dp),
        text = statusMessage
    )
}

@Composable
fun CellComponent(item: CellState, onClick: () -> Unit) {
    OutlinedButton(
        modifier = Modifier
            .width(100.dp)
            .height(50.dp)
            .padding(top = 5.dp, start = 5.dp),
        onClick = onClick,
    ) {
        Text(if (item != CellState.EMPTY) item.name else "")
    }
}