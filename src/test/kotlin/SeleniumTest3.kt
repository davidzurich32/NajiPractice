import org.junit.jupiter.api.Test
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WindowType
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.WebDriverWait
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.time.Duration

class SeleniumTest3 {

    @Test
    fun firstTest(){
        var chromeDriver = ChromeDriver()

        var waitDriver = WebDriverWait(chromeDriver, Duration.ofSeconds(5))
        chromeDriver.get("https://www.insidetracker.com/")
        val currentWindow = chromeDriver.windowHandles.first()


        chromeDriver.switchTo().newWindow(WindowType.WINDOW)
        Thread.sleep(5000)

        chromeDriver.switchTo().window(currentWindow)

        val scrFile = (chromeDriver as TakesScreenshot).getScreenshotAs(OutputType.FILE)
        Files.copy(scrFile.toPath(), Paths.get("/chrome/abc.jpeg"), StandardCopyOption.REPLACE_EXISTING)




    }
}