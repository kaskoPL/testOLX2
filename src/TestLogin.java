import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.is;

public class TestLogin {
    @Test
    public void TestLogin(){
        WebDriver driver = new ChromeDriver();

        SignIn signInPage = new SignIn(driver);
        HomePage homePage = signInPage.loginUser("username","password");
        assertThat(homePage.getMessageText(), is("Hello userName"));
    }
}
