import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Ksenia on 28.10.2016.
 */
public class FramePage {

    private static final By INPUT_AREA = By.id("tinymce");
    private static final By BOLD_BUTTON = By.cssSelector("#mceu_3>button");
    private static final String hello = "Hello ";
    private static final String world = "world!";
    private WebDriver driver;
    WebElement inputForMassage;

    public FramePage(WebDriver driver){
        this.driver = driver;
    }

    public String setMassage(WebDriver driver){
        initFrame(driver);
        inputForMassage.clear();

        switchBold(driver);
        initFrame(driver);
        inputForMassage.sendKeys(hello);

        switchBold(driver);
        initFrame(driver);
        inputForMassage.sendKeys(world);

        return inputForMassage.getText().replace(" \uFEFF", " ");
    }

    private void initFrame(WebDriver driver){
        driver.switchTo().frame("mce_0_ifr");
        inputForMassage = driver.findElement(INPUT_AREA);
    }

    private void switchBold(WebDriver driver){
        driver.switchTo().defaultContent();
        WebElement boldButton = driver.findElement(BOLD_BUTTON);
        boldButton.click();
    }


}
