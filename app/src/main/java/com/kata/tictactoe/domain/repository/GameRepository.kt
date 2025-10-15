package com.kata.tictactoe.domain.repository

import com.kata.tictactoe.domain.model.CellState
import com.kata.tictactoe.domain.model.Player

interface GameRepository {
    fun checkWinner(paths: List<List<CellState>>): Player?
}