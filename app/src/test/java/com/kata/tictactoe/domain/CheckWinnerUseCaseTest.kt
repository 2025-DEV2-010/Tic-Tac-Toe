package com.kata.tictactoe.domain

import com.kata.tictactoe.domain.model.CellState
import com.kata.tictactoe.domain.model.Player
import com.kata.tictactoe.domain.repository.GameRepository
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class CheckWinnerUseCaseTest {

    private lateinit var gameRepository: GameRepository
    private lateinit var checkWinnerUseCase: CheckWinnerUseCase

    @Before
    fun setUp() {
        gameRepository = mock(GameRepository::class.java)
        checkWinnerUseCase = CheckWinnerUseCase(gameRepository = gameRepository)
    }

    @Test
    fun `test execute with winning path returns correct player`() {
        val paths = listOf(
            listOf(CellState.X, CellState.X, CellState.X),
            listOf(CellState.EMPTY, CellState.EMPTY, CellState.EMPTY),
            listOf(CellState.EMPTY, CellState.EMPTY, CellState.EMPTY)
        )
        Mockito.`when`(gameRepository.checkWinner(paths)).thenReturn(Player.X)

        val winner = checkWinnerUseCase.execute(paths)

        assertEquals(winner, Player.X)
    }

    @Test
    fun `test execute with different paths returns correct player`() {
        val paths = listOf(
            listOf(CellState.O, CellState.O, CellState.O),
            listOf(CellState.X, CellState.EMPTY, CellState.EMPTY),
            listOf(CellState.EMPTY, CellState.EMPTY, CellState.EMPTY)
        )
        Mockito.`when`(gameRepository.checkWinner(paths)).thenReturn(Player.O)

        val winner = checkWinnerUseCase.execute(paths)

        assertEquals(winner, Player.O)
    }

}