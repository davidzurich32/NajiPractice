import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.config.LogConfig
import io.restassured.config.RestAssuredConfig
import io.restassured.filter.log.LogDetail
import io.restassured.specification.RequestSpecification
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class RestAssuredBase4 {
    companion object{
        lateinit var requestSpecification: RequestSpecification
    }

    @BeforeAll
    fun beforeAll(){
        val logConfig = LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL)
        val config = RestAssuredConfig.config().logConfig(logConfig)
        requestSpecification = RequestSpecBuilder()
            .setBaseUri("https://reqres.in")
            .setBasePath("api")
            .setRelaxedHTTPSValidation()
            .setConfig(config)
            .build()
    }

    @AfterAll
    fun afterAll(){
        RestAssured.reset()
    }
}