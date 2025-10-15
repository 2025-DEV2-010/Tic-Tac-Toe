package data.repository

import com.kata.tictactoe.data.repository.GameEngine
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class GameEngineTest {

    lateinit var gameEngine: GameEngine

    @Before
    fun setup() {
        gameEngine = GameEngine()
    }

    @Test
    fun `verify valid first row winning path`() {
        val expectedData = listOf(0, 1, 2)

        val actualData = gameEngine.generateWinningPaths()
        val isValid = actualData.contains(expectedData)

        assertTrue(isValid)
    }

    @Test
    fun `verify valid second row winning path`() {
        val expectedData = listOf(3, 4, 5)

        val actualData = gameEngine.generateWinningPaths()
        val isValid = actualData.contains(expectedData)

        assertTrue(isValid)
    }

    @Test
    fun `verify valid third row winning path`() {
        val expectedData = listOf(6, 7, 8)

        val actualData = gameEngine.generateWinningPaths()
        val isValid = actualData.contains(expectedData)

        assertTrue(isValid)
    }

    @Test
    fun `verify invalid row path`() {
        val expectedData = listOf(0, 1, 3)

        val actualData = gameEngine.generateWinningPaths()
        val isValid = actualData.contains(expectedData)

        assertFalse(isValid)
    }

    @Test
    fun `verify valid first column winning path`() {
        val expectedData = listOf(0, 3, 6)

        val actualData = gameEngine.generateWinningPaths()
        val isValid = actualData.contains(expectedData)

        assertTrue(isValid)
    }

    @Test
    fun `verify valid second column winning path`() {
        val expectedData = listOf(1, 4, 7)

        val actualData = gameEngine.generateWinningPaths()
        val isValid = actualData.contains(expectedData)

        assertTrue(isValid)
    }

    @Test
    fun `verify valid third column winning path`() {
        val expectedData = listOf(2, 5, 8)

        val actualData = gameEngine.generateWinningPaths()
        val isValid = actualData.contains(expectedData)

        assertTrue(isValid)
    }

    @Test
    fun `verify invalid column paths`() {
        val expectedData = listOf(0, 3, 8)

        val actualData = gameEngine.generateWinningPaths()
        val isValid = actualData.contains(expectedData)

        assertFalse(isValid)
    }

    @Test
    fun `verify valid main diagonal win path`() {
        val expectedData = listOf(0, 4, 8)

        val actualData = gameEngine.generateWinningPaths()
        val isValid = actualData.contains(expectedData)

        assertTrue(isValid)
    }

    @Test
    fun `verify valid anti diagonal win path`() {
        val expectedData = listOf(2, 4, 6)

        val actualData = gameEngine.generateWinningPaths()
        val isValid = actualData.contains(expectedData)

        assertTrue(isValid)
    }
}