package com.kata.tictactoe.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import com.kata.tictactoe.domain.CheckWinnerUseCase
import com.kata.tictactoe.domain.model.CellState
import com.kata.tictactoe.domain.model.GameOutcome
import com.kata.tictactoe.domain.model.Player
import com.kata.tictactoe.presentation.model.GameProgress
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

class GameBoardViewModelTest {

    private lateinit var viewModelTest: GameBoardViewModel
    private lateinit var mockUseCase: CheckWinnerUseCase
    private val _gameProgressState = mutableStateOf(
        GameProgress()
    )

    @Before
    fun setUp() {
        mockUseCase = mock()

        viewModelTest = GameBoardViewModel(mockUseCase).apply {
            _gameProgressState.value = GameProgress(
                currentMovePlayer = Player.X,
                playerMovedPositions = List(3) { MutableList(3) { CellState.EMPTY } }
            )
        }
    }

    @Test
    fun `Player X move updates cell and switches to Player O`() {
        whenever(
            mockUseCase.execute(any())
        ).thenReturn(null)

        viewModelTest.updatePlayMoveStatus(1, 1)

        val state = viewModelTest.gameProgressState.value
        assertEquals(CellState.X, state.playerMovedPositions[1][1])
        assertEquals(Player.O, state.currentMovePlayer)
        assertEquals("Player O", state.statusMessage)
        assertEquals(GameOutcome.ONGOING, state.gameOutComeStatus)
    }

    @Test
    fun `Player O move updates cell and switches to Player X`() {
        viewModelTest.updateCurrentPlayer(Player.O)

        whenever(
            mockUseCase.execute(any())
        ).thenReturn(null)

        viewModelTest.updatePlayMoveStatus(2, 2)

        val state = viewModelTest.gameProgressState.value
        assertEquals(CellState.O, state.playerMovedPositions[2][2])
        assertEquals(Player.X, state.currentMovePlayer)
        assertEquals("Player X", state.statusMessage)
        assertEquals(GameOutcome.ONGOING, state.gameOutComeStatus)
    }

    @Test
    fun `when useCase returns winner, game outcome is WIN`() {
        whenever(
            mockUseCase.execute(any())
        ).thenReturn(Player.X)

        viewModelTest.updatePlayMoveStatus(0, 0)

        val state = viewModelTest.gameProgressState.value
        assertEquals(GameOutcome.WIN, state.gameOutComeStatus)
    }
}