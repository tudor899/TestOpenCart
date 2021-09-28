import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver webDriver;

    @BeforeClass
    public void setUpOnce(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void setUpBeforeEachTest(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        //Specifiying pageLoadTimeout and Implicit wait
        webDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.get("http://localhost/upload");
    }

    @AfterMethod
    public void closeWindow(){
        //webDriver.close();
    }

}
