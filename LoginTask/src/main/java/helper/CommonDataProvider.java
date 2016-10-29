package helper;

import org.testng.annotations.DataProvider;

/**
 * Created by Ksenia on 29.10.2016.
 */
public class CommonDataProvider {

    private static final String USERNAME = "tomsmith";
    private static final String PASSWORD = "SuperSecretPassword!";
    private static final String SUCCESSFUL_LOGIN = "You logged into a secure area!";
    private static final String FAIL_PASSWORD = "Your password is invalid!";
    private static final String FAIL_USERNAME = "Your username is invalid!";

    @DataProvider
    public static Object[][] loginDataProvider() {
        return new Object[][]{
                new Object[]{"", "", FAIL_USERNAME},
                new Object[]{USERNAME, "", FAIL_PASSWORD},
                new Object[]{"", PASSWORD, FAIL_USERNAME},
                new Object[]{USERNAME, "SecretPassword", FAIL_PASSWORD},
                new Object[]{"tom", PASSWORD, FAIL_USERNAME},
                new Object[]{USERNAME, PASSWORD, SUCCESSFUL_LOGIN},
                new Object[]{"tom", "SecretPassword", FAIL_USERNAME}
        };
    }
}
