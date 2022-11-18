import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.time.Duration

class SeleniumTest4 {

    @Test
    fun firstSeleniumTest(){
        val chromeDriver = ChromeDriver()
        var waitChromeDriver = WebDriverWait(chromeDriver, Duration.ofSeconds(10))

        chromeDriver.get("https://www.google.es/")
        chromeDriver.manage().window().maximize()

        val acceptButton = chromeDriver.findElement(By.id("L2AGLb"))
        acceptButton.click()
        val element = waitChromeDriver.until(ExpectedConditions.presenceOfElementLocated(By.name("btnK")))


        Thread.sleep(3000)
        chromeDriver.findElement(By.name("q")).sendKeys("abc")

        val file = (chromeDriver as TakesScreenshot).getScreenshotAs(OutputType.FILE)
        Files.copy(file.toPath(), Paths.get("/chrome/abc.jpeg"), StandardCopyOption.REPLACE_EXISTING)
        element.submit()

        Thread.sleep(5000)
        chromeDriver.quit()

    }
}