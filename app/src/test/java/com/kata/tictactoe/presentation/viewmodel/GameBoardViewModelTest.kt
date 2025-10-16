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

    private lateinit var viewModel: GameBoardViewModel
    private lateinit var mockUseCase: CheckWinnerUseCase
    private val _gameProgressState = mutableStateOf(
        GameProgress()
    )

    @Before
    fun setUp() {
        mockUseCase = mock()

        viewModel = GameBoardViewModel(mockUseCase).apply {
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

        viewModel.updatePlayMoveStatus(1, 1)

        val state = viewModel.gameProgressState.value
        assertEquals(CellState.X, state.playerMovedPositions[1][1])
        assertEquals(Player.O, state.currentMovePlayer)
        assertEquals("Player O", state.statusMessage)
        assertEquals(GameOutcome.ONGOING, state.gameOutComeStatus)
    }

}