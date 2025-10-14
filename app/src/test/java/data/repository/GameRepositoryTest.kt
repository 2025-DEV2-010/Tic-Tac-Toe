package data.repository

import com.kata.tictactoe.utils.generateWinningPaths
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class GameRepositoryTest {

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
}