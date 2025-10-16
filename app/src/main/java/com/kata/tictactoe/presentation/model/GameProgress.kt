package com.kata.tictactoe.presentation.model

import com.kata.tictactoe.domain.model.CellState
import com.kata.tictactoe.domain.model.GameOutcome
import com.kata.tictactoe.domain.model.Player

data class GameProgress(
    val boxSize: Int = 3,
    val playerMovedPositions: List<MutableList<CellState>> = List(boxSize) {
        MutableList(boxSize) {
            CellState.EMPTY
        }
    },
    val currentMovePlayer: Player = Player.X,
    val statusMessage: CellState = CellState.X,
    val gameOutComeStatus: GameOutcome = GameOutcome.ONGOING,
    val isDraw: Boolean = false
)
