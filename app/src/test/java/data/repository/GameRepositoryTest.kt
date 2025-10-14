package data.repository

import com.kata.tictactoe.data.repository.GameRepositoryImpl
import com.kata.tictactoe.domain.model.GameOutcome
import com.kata.tictactoe.domain.model.Player
import com.kata.tictactoe.utils.generateWinningPaths
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class GameRepositoryTest {

    lateinit var gameRepository: GameRepositoryImpl

    @Before
    fun setup() {
        gameRepository = GameRepositoryImpl()
    }

    @Test
    fun `verify valid first row winning path`() {
        val expectedData = listOf(0, 1, 2)

        val actualData = generateWinningPaths()
        val isValid = actualData.contains(expectedData)

        assertTrue(isValid)
    }

    @Test
    fun `verify valid second row winning path`() {
        val expectedData = listOf(3, 4, 5)

        val actualData = generateWinningPaths()
        val isValid = actualData.contains(expectedData)

        assertTrue(isValid)
    }

    @Test
    fun `verify valid third row winning path`() {
        val expectedData = listOf(6, 7, 8)

        val actualData = generateWinningPaths()
        val isValid = actualData.contains(expectedData)

        assertTrue(isValid)
    }

    @Test
    fun `verify invalid row path`() {
        val expectedData = listOf(0, 1, 3)

        val actualData = generateWinningPaths()
        val isValid = actualData.contains(expectedData)

        assertFalse(isValid)
    }

    @Test
    fun `verify valid first column winning path`() {
        val expectedData = listOf(0, 3, 6)

        val actualData = generateWinningPaths()
        val isValid = actualData.contains(expectedData)

        assertTrue(isValid)
    }

    @Test
    fun `verify valid second column winning path`() {
        val expectedData = listOf(1, 4, 7)

        val actualData = generateWinningPaths()
        val isValid = actualData.contains(expectedData)

        assertTrue(isValid)
    }

    @Test
    fun `verify valid third column winning path`() {
        val expectedData = listOf(2, 5, 8)

        val actualData = generateWinningPaths()
        val isValid = actualData.contains(expectedData)

        assertTrue(isValid)
    }

    @Test
    fun `verify invalid column paths`() {
        val expectedData = listOf(0, 3, 8)

        val actualData = generateWinningPaths()
        val isValid = actualData.contains(expectedData)

        assertFalse(isValid)
    }

    @Test
    fun `verify valid main diagonal win path`() {
        val expectedData = listOf(0, 4, 8)

        val actualData = generateWinningPaths()
        val isValid = actualData.contains(expectedData)

        assertTrue(isValid)
    }

    @Test
    fun `verify valid anti diagonal win path`() {
        val expectedData = listOf(2, 4, 6)

        val actualData = generateWinningPaths()
        val isValid = actualData.contains(expectedData)

        assertTrue(isValid)
    }

    @Test
    fun `verify player-x possible winning scenario`() {
        val expectedData = listOf(listOf(0, 1, 2), listOf(0, 3, 6), listOf(0, 4, 8))

        val actualOutcome = gameRepository.checkWinner(player = Player.X, paths = expectedData)

        assertEquals(GameOutcome.WIN, actualOutcome)
    }
}