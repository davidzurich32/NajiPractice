import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import io.restassured.response.Response
import org.apache.http.HttpStatus
import org.hamcrest.Matchers
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test

class RestAssuredFirstTest: RestAssuredBase() {

    @Test
    fun firstTest(){
        var response:Response
        Given {
            spec(requestSpecification)
        } When {
            get("/users")
        } Then{
            statusCode(HttpStatus.SC_OK)
            body("page", equalTo(1))
            body("data[1].id", equalTo(3))
        } Extract {
            response = response()
            response.body.prettyPrint()

        }




    }


}