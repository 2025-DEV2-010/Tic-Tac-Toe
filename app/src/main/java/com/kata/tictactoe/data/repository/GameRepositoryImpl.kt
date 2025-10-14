package com.kata.tictactoe.data.repository

import com.kata.tictactoe.domain.model.GameOutcome
import com.kata.tictactoe.domain.model.Player
import com.kata.tictactoe.domain.repository.GameRepository
import com.kata.tictactoe.utils.generateWinningPaths

class GameRepositoryImpl : GameRepository {

    override fun checkWinner(
        player: Player,
        paths: List<List<Int>>
    ): GameOutcome {

        val winningPaths = generateWinningPaths()

        val winningStatus = paths.any { item ->
            winningPaths.contains(item.sorted())
        }

        return if (winningStatus) {
            GameOutcome.WIN
        } else {
            when {
                player == Player.X && paths.size == 4 -> {
                    return GameOutcome.DRAW
                }

                player == Player.O && paths.size == 3 -> {
                    return GameOutcome.DRAW
                }

                else -> {
                    GameOutcome.ONGOING
                }
            }
        }
    }

}