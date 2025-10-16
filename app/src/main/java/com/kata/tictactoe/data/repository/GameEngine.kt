package com.kata.tictactoe.data.repository

class GameEngine(private val boardSize: Int = 3) {

    fun generateWinningPaths(): List<List<Int>> {

        val pathList = mutableListOf<List<Int>>()

        pathList.addAll(getWinningRowItems())
        pathList.addAll(getWinningColumnItems())
        pathList.add(getMainDiagonalItem())
        pathList.add(getAntiDiagonalItem())

        return pathList
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

}