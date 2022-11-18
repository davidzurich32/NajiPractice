import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration


class SeleniumTest {

    @Test
    fun `first selenium Test`() {
        System.setProperty("webdriver.chrome.driver","/chrome/chromedriver.exe")


        val driver = ChromeDriver()
        val waitDriver = WebDriverWait(driver, Duration.ofSeconds(3))
        driver.get("https://www.insidetracker.com/")

        driver.manage().window().maximize()

        waitDriver.until(ExpectedConditions.presenceOfElementLocated (By.id("logInLink"))).click()

        waitDriver.until(ExpectedConditions.presenceOfElementLocated (By.id("email"))).sendKeys("davidcoburg@cmail.cat")
        Thread.sleep(5000)
        driver.quit()

        //driver.quit()



    }

    @Test
    fun scrollTest (){

        System.setProperty("webdriver.chrome.driver", "/chrome/chromedriver.exe")
        val driver = ChromeDriver()

        driver.get("https://www.browserstack.com/guide/selenium-scroll-tutorial")

        driver.manage().window().maximize()


        Thread.sleep(5000)

        //Locating element by link text and store in variable "Element"
        val element = driver.findElement(By.linkText("Try Selenium Testing For Free"))


        // Scrolling down the page till the element is found
        driver.executeScript("arguments[0].scrollIntoView();", element)

        Thread.sleep(5000)


        driver.quit()



    }

    @Test
    fun alert (){
        System.setProperty("webdriver.chrome.driver", "/chrome/chromedriver.exe")

        val driver = ChromeDriver()
        val waitDriver = WebDriverWait(driver, Duration.ofSeconds(3))

        driver.get("https://demo.guru99.com/test/delete_customer.php")

        driver.findElement(By.name("cusid")).sendKeys("53920");
        driver.findElement(By.name("submit")).submit();

        val alert = driver.switchTo().alert()

        Thread.sleep(5000)
        alert.dismiss()

        Thread.sleep(5000)



    }




}