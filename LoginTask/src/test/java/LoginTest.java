import helper.CommonDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ksenia on 29.10.2016.
 */
public class LoginTest {

    private static final String URL = "http://the-internet.herokuapp.com/login";
    private static final By MASSAGE = By.xpath("//a[@class = \"close\"]/..");
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void createBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);

        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void killBrowser() {
        driver.close();
    }

    @Test(dataProviderClass = CommonDataProvider.class, dataProvider = "loginDataProvider")
    public void LoginDDTTest(String username, String password, String massage) {
        String actualResult = loginPage.loginDDT(username, password, massage);
        String expectedResult = driver.findElement(MASSAGE).getText().replace("\n" + "×", "");
        Assert.assertEquals(actualResult, expectedResult);
    }

}
