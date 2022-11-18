import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import kotlinx.serialization.json.Json
import org.apache.http.HttpStatus
import org.junit.jupiter.api.Test

class SampleTest5: RestAssuredBase4() {

    @Test
    fun firstTest(){
        Given{
            spec(requestSpecification)

        } When {
            get("/users/1")
        } Then {
            statusCode(HttpStatus.SC_OK)
        }
    }
}