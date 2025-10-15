package data.repository

import com.kata.tictactoe.data.repository.GameRepositoryImpl
import com.kata.tictactoe.domain.model.GameOutcome
import com.kata.tictactoe.domain.model.Player
import com.kata.tictactoe.domain.repository.GameRepository
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class GameRepositoryImplTest {

    lateinit var gameRepository: GameRepository

    @Before
    fun setup() {
        gameRepository = GameRepositoryImpl()
    }

    @Test
    fun `verify possible win scenario for player`() {
        val expectedData = listOf(listOf(0, 1, 2), listOf(5, 6))

        val actualOutcome =
            gameRepository.checkWinner(
                boardSize = (3 * 3),
                player = Player.X,
                paths = expectedData
            )

        assertEquals(GameOutcome.WIN, actualOutcome)
    }
}