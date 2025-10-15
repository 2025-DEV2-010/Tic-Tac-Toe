package com.kata.tictactoe.data.repository

import com.kata.tictactoe.domain.model.GameOutcome
import com.kata.tictactoe.domain.model.Player
import com.kata.tictactoe.domain.repository.GameRepository

class GameRepositoryImpl(private val gameEngine: GameEngine = GameEngine()) : GameRepository {

    private val winningPaths by lazy { gameEngine.generateWinningPaths() }

    override fun checkWinner(
        boardSize: Int,
        player: Player,
        paths: List<List<Int>>
    ): GameOutcome {

        val winningStatus = paths.any { item ->
            winningPaths.contains(item.sorted())
        }

        if (winningStatus) {
            return GameOutcome.WIN
        }

        val movePathSize = paths.flatten().size
        val maxMovesForPlayerX = (boardSize / 2)
        val maxMovesForPlayerO = (boardSize / 2) - 1

        return when {
            player == Player.X && movePathSize >= maxMovesForPlayerX -> {
                GameOutcome.DRAW
            }

            player == Player.O && movePathSize >= maxMovesForPlayerO -> {
                GameOutcome.DRAW
            }

            else -> {
                GameOutcome.ONGOING
            }
        }
    }
}
