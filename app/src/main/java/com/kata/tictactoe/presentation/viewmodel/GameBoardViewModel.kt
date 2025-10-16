package com.kata.tictactoe.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.kata.tictactoe.domain.CheckWinnerUseCase
import com.kata.tictactoe.domain.model.CellState
import com.kata.tictactoe.domain.model.GameOutcome
import com.kata.tictactoe.domain.model.Player
import com.kata.tictactoe.presentation.model.GameProgress
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameBoardViewModel(
    private val useCase: CheckWinnerUseCase = CheckWinnerUseCase()
) : ViewModel() {

    private val _gameProgressState = MutableStateFlow(GameProgress())
    val gameProgressState = _gameProgressState.asStateFlow()

    fun updatePlayMoveStatus(rowIndex: Int, columnIndex: Int) {

        val currentState = _gameProgressState.value
        val selectedItems = currentState.playerMovedPositions

        val statusMessage = when {
            selectedItems[rowIndex][columnIndex] != CellState.EMPTY -> {
                CellState.INVALID
            }

            currentState.currentMovePlayer == Player.X -> {
                selectedItems[rowIndex][columnIndex] = CellState.X
                CellState.O
            }

            else -> {
                selectedItems[rowIndex][columnIndex] = CellState.O
                CellState.X
            }
        }

        val winningStatus = useCase.execute(selectedItems)
        val drawStatus = selectedItems.all { item -> item.all { it != CellState.EMPTY } }

        _gameProgressState.update {
            it.copy(
                isDraw = drawStatus,
                statusMessage = statusMessage,
                playerMovedPositions = selectedItems,
                gameOutComeStatus = if (winningStatus == null) GameOutcome.ONGOING else GameOutcome.WIN,
                currentMovePlayer = if (winningStatus != null) currentState.currentMovePlayer else updateCurrentPlayer(
                    currentState.currentMovePlayer
                ),
            )
        }
    }

    fun updateCurrentPlayer(player: Player): Player {
        return if (player == Player.X) Player.O else Player.X
    }

    fun resetGame() {
        _gameProgressState.value = GameProgress()
    }

}