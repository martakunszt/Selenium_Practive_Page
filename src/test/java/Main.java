import io.github.bonigarcia.wdm.WebDriverManager; //importing WebDriver Manager
import org.junit.jupiter.api.*; //importing Jupiter
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.assertj.core.api.Assertions; //adding assertions library
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration; //to add wait/timeouts etc
public class Main {
    private static WebDriver driver;
    String sut = "https://automationintesting.com/selenium/testpage/";

    @BeforeAll
    static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
     void setup(){
        driver = WebDriverManager.chromiumdriver().create(); //creating browser's instance
    }

    @AfterEach
    void teardown(){
        driver.quit(); // closing browser window
    }

    @Test
    public void openPage(){
        driver.get(sut);
        String expectedUrl = "https://automationintesting.com/selenium/testpage/";
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertThat(currentUrl).isEqualTo(expectedUrl);
    }
}
