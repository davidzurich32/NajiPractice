import io.restassured.RestAssured
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import kotlinx.serialization.Required
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.apache.http.HttpStatus
import org.junit.jupiter.api.Test

class SampleTest2 : RestAssuredBase2() {

    @Test
    fun firstTest() {
        Given {
            spec(requestSpecification)
        } When {
            get("/users/1")
        } Then {
            statusCode(HttpStatus.SC_OK)
        }

    }

    @Test
    fun insert() {
        val requestBody = Users("John", "Manager")
        Given {
            spec(requestSpecification)
            body(Json.encodeToString(requestBody))
        } When {
            post("/users")
        } Then {
            statusCode(HttpStatus.SC_CREATED)
        }
    }

    @Serializable
    data class Users(@Required val name: String, @Required val job: String)
}