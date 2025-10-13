package com.kata.tictactoe.utils

fun generateWinningPaths(boardSize: Int = 3): List<List<Int>> {

    val winPathList = mutableListOf<List<Int>>()

    for (row in 0  until boardSize) {
        val rows = (0 until boardSize).map { col -> row * boardSize + col }
        winPathList.add(rows)
    }

    return winPathList
}