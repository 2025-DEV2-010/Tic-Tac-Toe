package com.kata.tictactoe.data.repository

class GameEngine(private val boardSize: Int = 3) {

    fun generateWinningPaths(): List<List<Int>> {

        val pathList = mutableListOf<List<Int>>()

        for (row in 0 until boardSize) {
            val rows = (0 until boardSize).map { column -> row * boardSize + column }
            pathList.add(rows)
        }

        for (row in 0 until boardSize) {
            val rows = (0 until boardSize).map { column -> column * boardSize + row }
            pathList.add(rows)
        }

        val mainDiagonal = (0 until boardSize).map { item -> item * boardSize + item }
        pathList.add(mainDiagonal)

        val antiDiagonal =
            (0 until boardSize).map { item -> item * boardSize + (boardSize - 1 - item) }
        pathList.add(antiDiagonal)

        return pathList
    }
}