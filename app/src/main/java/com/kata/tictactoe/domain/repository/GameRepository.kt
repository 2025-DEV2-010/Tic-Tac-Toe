package com.kata.tictactoe.domain.repository

import com.kata.tictactoe.domain.model.GameOutcome
import com.kata.tictactoe.domain.model.Player

interface GameRepository {
    fun checkWinner(boardSize: Int, player: Player, paths: List<List<Int>>): GameOutcome
}