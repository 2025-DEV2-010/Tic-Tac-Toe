package com.kata.tictactoe.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.kata.tictactoe.domain.CheckWinnerUseCase
import com.kata.tictactoe.domain.model.CellState
import com.kata.tictactoe.domain.model.GameOutcome
import com.kata.tictactoe.domain.model.Player
import com.kata.tictactoe.presentation.model.GameProgress
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameBoardViewModel(
    private val useCase: CheckWinnerUseCase = CheckWinnerUseCase()
) : ViewModel() {

    private val _gameProgressState = MutableStateFlow(GameProgress())
    val gameProgressState = _gameProgressState.asStateFlow()

    fun updatePlayMoveStatus(rowIndex: Int, columnIndex: Int) {

        val currentState = _gameProgressState.value
        val selectedItems = currentState.playerMovedPositions
        var statusMessage = ""

        when {
            selectedItems[rowIndex][columnIndex] != CellState.EMPTY -> {
                statusMessage = "Invalid Move"
            }

            currentState.currentMovePlayer == Player.X -> {
                selectedItems[rowIndex][columnIndex] = CellState.X
                statusMessage = "Player O"
            }

            else -> {
                selectedItems[rowIndex][columnIndex] = CellState.O
                statusMessage = "Player X"
            }
        }

        val winningStatus = useCase.execute(selectedItems)
        val drawStatus = selectedItems.all { item -> item.all { it != CellState.EMPTY } }

        _gameProgressState.value = currentState.copy(
            statusMessage = if (drawStatus) "Match Draw" else statusMessage,
            playerMovedPositions = selectedItems,
            gameOutComeStatus = if (winningStatus == null) GameOutcome.ONGOING else GameOutcome.WIN,
            currentMovePlayer = if (currentState.currentMovePlayer == Player.X && winningStatus == null) Player.O else Player.X,
        )
    }

    fun updateCurrentPlayer(player: Player) {
        _gameProgressState.value = _gameProgressState.value.copy(currentMovePlayer = player)
    }

    fun resetGame() {
        _gameProgressState.value = GameProgress()
    }

}