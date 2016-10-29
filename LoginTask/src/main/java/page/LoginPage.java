package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Created by Ksenia on 29.10.2016.
 */
public class LoginPage {

    private WebDriver driver;
    private static final By LOGIN_INPUT = By.id("username");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.cssSelector(".radius");
    private static final String USERNAME = "tomsmith";
    private static final String PASSWORD = "SuperSecretPassword!";
    private static final String SUCCESSFUL_LOGIN = "You logged into a secure area!";
    private static final String FAIL_PASSWORD = "Your password is invalid!";
    private static final String FAIL_USERNAME = "Your username is invalid!";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String loginDDT(String username, String password, String massage) {
        driver.findElement(LOGIN_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();

        if (username == USERNAME) {
            if (password == PASSWORD) {
                massage = SUCCESSFUL_LOGIN;
            } else {
                massage = FAIL_PASSWORD;
            }
        }

        if (username != USERNAME) {
            massage = FAIL_USERNAME;
        }
        return massage;
    }
}
