import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.config.LogConfig
import io.restassured.config.RestAssuredConfig
import io.restassured.filter.log.LogDetail
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class RestAssuredBase {

    companion object{
        lateinit var requestSpecification: RequestSpecification
    }

    @BeforeAll
    fun setup(){
        val logConfig = LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL)
        val config = RestAssuredConfig.config().logConfig(logConfig)

        requestSpecification = RequestSpecBuilder()
            .setBaseUri("https://reqres.in")
            .setBasePath("/api")
            .setConfig(config)
            .setRelaxedHTTPSValidation()
            .setContentType(ContentType.JSON)
            .build()
    }

    @AfterAll
    fun tearDown(){
        RestAssured.reset()
    }
}