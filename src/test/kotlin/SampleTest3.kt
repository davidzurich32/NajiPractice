import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import io.restassured.response.ResponseBodyExtractionOptions
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.apache.http.HttpStatus
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test

class SampleTest3 : RestAssuredBase3() {

    @Test
    fun firstTest() {
        Given { spec(requestSpecification)
        }When {
            get("/users/1")
        } Then {
            statusCode(HttpStatus.SC_OK)
        }
    }

    @Test
    fun secondTest(){
        val user = Users("martin", "engineer")
        var body:ResponseBodyExtractionOptions? = null
        Given{
            spec(requestSpecification)
            body(Json.encodeToString(user))
        } When {
            post("/users")
        } Then{
            statusCode(HttpStatus.SC_CREATED)
            time(Matchers.lessThan(1000L))
        }Extract {
            body = body()

        }
        val response = body!!.asString()

    }

    @Serializable
    data class Users(val name: String, val job: String)
}