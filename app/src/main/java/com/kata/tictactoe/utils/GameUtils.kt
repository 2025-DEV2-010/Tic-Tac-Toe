package com.kata.tictactoe.utils

fun generateWinningPaths(boardSize: Int = 3): List<List<Int>> {

    val winPathList = mutableListOf<List<Int>>()

    for (row in 0  until boardSize) {
        val rows = (0 until boardSize).map { col -> row * boardSize + col }
        winPathList.add(rows)
    }

    for (row in 0 until boardSize) {
        val rows = (0 until boardSize).map { col -> col * boardSize + row }
        winPathList.add(rows)
    }

    val mainDiagonal = (0 until boardSize).map { item -> item * boardSize + item }
    winPathList.add(mainDiagonal)

    val antiDiagonal = (0 until boardSize).map { item -> item * boardSize + (boardSize - 1 - item) }
    winPathList.add(antiDiagonal)

    return winPathList
}