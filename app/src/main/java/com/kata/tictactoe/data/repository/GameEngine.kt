package com.kata.tictactoe.data.repository

import com.kata.tictactoe.domain.model.CellState
import com.kata.tictactoe.domain.model.Player

class GameEngine(private val boardSize: Int = 3) {

    private val winningPaths = mutableListOf<List<Int>>()

    init {
        generateWinningPaths()
    }
    fun generateWinningPaths(): List<List<Int>> {

        winningPaths.addAll(getWinningRowItems())
        winningPaths.addAll(getWinningColumnItems())
        winningPaths.add(getMainDiagonalItem())
        winningPaths.add(getAntiDiagonalItem())

        return winningPaths
    }

    private fun getWinningRowItems(): MutableList<List<Int>> {
        val rowList = mutableListOf<List<Int>>()
        for (row in 0 until boardSize) {
            val rows = (0 until boardSize).map { col -> row * boardSize + col }
            rowList.add(rows)
        }
        return rowList
    }

    private fun getWinningColumnItems(): MutableList<List<Int>> {
        val columnList = mutableListOf<List<Int>>()
        for (row in 0 until boardSize) {
            val rows = (0 until boardSize).map { col -> col * boardSize + row }
            columnList.add(rows)
        }
        return columnList
    }

    private fun getMainDiagonalItem(): List<Int> {
        return (0 until boardSize).map { item -> item * boardSize + item }
    }

    private fun getAntiDiagonalItem(): List<Int> {
        return (0 until boardSize).map { item -> item * boardSize + (boardSize - 1 - item) }
    }

    fun findWinner(userSelectedPaths: List<List<CellState>>): Player? {
        val board = userSelectedPaths.flatten().toTypedArray()

        for (line in winningPaths) {
            val first = board[line.first()]
            if (first == CellState.EMPTY) continue
            if (line.all { board[it] == first }) {
                return if (first == CellState.X) Player.X else Player.O
            }
        }
        return null
    }
}