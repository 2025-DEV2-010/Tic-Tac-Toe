package com.kata.tictactoe.data.repository

import com.kata.tictactoe.domain.model.CellState
import com.kata.tictactoe.domain.model.Player

class GameEngine(
    private val boardSize: Int = 3
) {
    val winningPaths by lazy { generateWinningPaths() }

    private fun generateWinningPaths(): List<List<Int>> {

        val possiblePaths = mutableListOf<List<Int>>()

        possiblePaths.addAll(getWinningRowItems())
        possiblePaths.addAll(getWinningColumnItems())
        possiblePaths.add(getMainDiagonalItem())
        possiblePaths.add(getAntiDiagonalItem())

        return possiblePaths
    }

    private fun getWinningRowItems(): List<List<Int>> {
        val rowList = mutableListOf<List<Int>>()
        for (row in 0 until boardSize) {
            val rows = (0 until boardSize).map { col -> row * boardSize + col }
            rowList.add(rows)
        }
        return rowList
    }

    private fun getWinningColumnItems(): List<List<Int>> {
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
            if (first == CellState.EMPTY) {
                continue
            }
            when {
                line.all { board[it] == first } -> {
                    return if (first == CellState.X) {
                        Player.X
                    } else {
                        Player.O
                    }
                }
            }
        }
        return null
    }
}