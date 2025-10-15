package com.kata.tictactoe.domain

import com.kata.tictactoe.data.repository.GameRepositoryImpl
import com.kata.tictactoe.domain.model.CellState
import com.kata.tictactoe.domain.model.Player
import com.kata.tictactoe.domain.repository.GameRepository

class CheckWinnerUseCase(
    private val gameRepository: GameRepository = GameRepositoryImpl()
) {
    fun execute(paths: List<List<CellState>>): Player? {
        return gameRepository.checkWinner(
            paths = paths
        )
    }
}