import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignIn {
    protected WebDriver driver;
    private By usernameBy = By.id("username");
    private By passwordBy = By.id("password");
    private By loginBy = By.cssSelector("button[class='radius']");
//    private By loginBy = By.cssSelector("button[data-testid='login-btn']");

    public SignIn(WebDriver driver) {
        this.driver = driver;

    }
    public HomePage loginUser(String username, String password){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(loginBy).click();
        return new HomePage(driver);
    }
    public HomePage manageProfile(){
        return new HomePage(driver);
    }
}
