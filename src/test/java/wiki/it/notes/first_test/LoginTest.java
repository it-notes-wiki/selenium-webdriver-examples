package wiki.it.notes.first_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class LoginTest {

    private WebDriver driver;

    @BeforeClass
    void setupClass() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    void validLoginTest() {
        driver.get("https://demoqa.com/login");
        String userName = "it-notes";
        driver.findElement(By.id("userName")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys("Aqa12345*");
        driver.findElement(By.id("login")).click();
        String userNameValue = driver.findElement(By.id("userName-value")).getText();
        assertEquals(userNameValue, userName, "Not valid user name value");
    }

    @AfterClass
    void tearDownClass() {
        driver.quit();
    }
}
