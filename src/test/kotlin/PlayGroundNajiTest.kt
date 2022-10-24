import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PlayGroundNajiTest {

    @Test
    fun firstTest(){
        val teamResults = mutableMapOf<String, String>()
        teamResults["A"] = "3:1,2:0,2:5,2:2"
        val result = PlaygroundNaji().liga(teamResults)
        assertEquals("A", result.second)
        assertEquals("7", result.first["A"])

    }
}