import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ksenia on 28.10.2016.
 */
public class FrameTest {

    private static final String URL = "http://the-internet.herokuapp.com/iframe";
    private static final String EXPECTED_RESULT = "Hello world!";
    private WebDriver driver;
    private FramePage framePage;


    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);

        framePage = new FramePage(driver);
    }

    @AfterMethod
    public void kill(){
        driver.close();
    }

    @Test
    public void inputMassage(){
        String actualResult = framePage.setMassage(driver);
        Assert.assertEquals(actualResult, EXPECTED_RESULT);
    }




}
