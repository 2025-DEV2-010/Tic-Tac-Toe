package data.repository

import com.kata.tictactoe.utils.generateWinningPaths
import junit.framework.TestCase.assertTrue
import org.junit.Test

class GameRepositoryTest {

    @Test
    fun `verify valid first row winning path`() {
        val actualData = listOf(0,1,2)

        val expectedData = generateWinningPaths()
        val isValid = expectedData.contains(actualData)

        assertTrue(isValid)
    }
}