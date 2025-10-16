package com.kata.tictactoe.data.repository

import com.kata.tictactoe.domain.model.CellState
import com.kata.tictactoe.domain.model.Player
import com.kata.tictactoe.domain.repository.GameRepository

class GameRepositoryImpl(
    private val gameEngine: GameEngine = GameEngine()
) : GameRepository {

    override fun checkWinner(
        paths: List<List<CellState>>
    ): Player? {
        return gameEngine.findWinner(userSelectedPaths = paths)
    }

}