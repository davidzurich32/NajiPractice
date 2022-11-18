import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

class SeleniumTest2 {

    @Test
    fun firstSeleniumTest(){
        System.setProperty("webdriver.chrome.driver", "/chrome/chromedriver.exe")
        val driver = ChromeDriver()

        driver.get("https://the-internet.herokuapp.com/javascript_alerts")
        val webDriverWait = WebDriverWait(driver, Duration.ofSeconds(10))


        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(), 'Pro')]"))).click()
        Thread.sleep(3000)
        val alert = driver.switchTo().alert()
        alert.sendKeys("abc")
        alert.accept()
        Thread.sleep(25000)


        //driver.quit()
    }
}