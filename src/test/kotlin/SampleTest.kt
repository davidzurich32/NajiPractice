@file:Suppress("ClassName")

import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import io.restassured.response.Response
import io.restassured.response.ResponseBodyExtractionOptions
import kotlinx.serialization.Required
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.apache.http.HttpStatus
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import kotlin.concurrent.timerTask

class `Sample Test` : BaseTest() {

    @Test
    fun `get single user`() {
        Given {
            spec(requestSpecification)
        } When {
            get("/users/1")
        } Then {
            statusCode(HttpStatus.SC_OK)
            body("data.email", equalTo("janet.weaver@reqres.in"))
        }
    }

    @Test
    fun `create a new user`() {
        val requestBody = Users("John", "Manager")
        var body:ResponseBodyExtractionOptions
        var time:Long
        var sessionId: String?
        var userId:String = ""
        var response:Response
        Given {
            spec(requestSpecification)
            body(Json.encodeToString(requestBody))
        } When {
            post("/users")

        } Then {
            statusCode(HttpStatus.SC_CREATED)
            body(
                "name", equalTo("John"),
                "job", equalTo("Manager")
            )

            time(lessThan(1000L))

        } Extract {
            body = body()
            time= time()
            sessionId = sessionId()
            userId = path("id")
            response = response()
        }
        assertThat(userId, `is`(notNullValue()))
    }
}

@Serializable
data class Users(@Required val name: String, @Required val job: String)