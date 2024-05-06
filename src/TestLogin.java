import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.is;

public class TestLogin {
    @Test
    public void TestLogin() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("http://the-internet.herokuapp.com/login");

        SignIn signInPage = new SignIn(driver);
        HomePage homePage = signInPage.loginUser("tomsmith","SuperSecretPassword!");
        assertThat(homePage.getMessageText(), is("Secure Area"));

        driver.close();
    }
}
