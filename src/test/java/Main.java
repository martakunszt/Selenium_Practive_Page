import io.github.bonigarcia.wdm.WebDriverManager; //importing WebDriver Manager
import org.junit.jupiter.api.*; //importing Jupiter
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.assertj.core.api.Assertions; //adding assertions library
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration; //to add wait/timeouts etc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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

  //  @AfterEach
    //void teardown(){
       // driver.quit(); // closing browser window
   // }

    @Test
    @Order(1)
    public void openPage(){
        driver.get(sut);
        String expectedUrl = "https://automationintesting.com/selenium/testpage/";
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertThat(currentUrl).isEqualTo(expectedUrl);
    }

    @Test
    @Order(2)
    public void firstName(){
        String[] sendName = {"Blueberry", "Raspberry", "BlackBerry"};
        driver.get(sut);
        for(int i = 0; i < sendName.length; i++){
            WebElement nameField = driver.findElement(By.id("firstname"));
            nameField.sendKeys(sendName[i]);
        }

    }

    @Test
    @Order(3)
    public void textField(){
        String sendText = "CHECKING TEXT AREA";
        driver.get(sut);
        WebElement field = driver.findElement(By.tagName("textarea"));
        new Actions(driver).scrollToElement(field).perform();
        field.click();
        field.clear();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        field.sendKeys(sendText);
        System.out.println(field.getAttribute("value"));
        //Assertions.assertThat(sendText).isEqualTo(field.getAttribute("value"));
    }


}
